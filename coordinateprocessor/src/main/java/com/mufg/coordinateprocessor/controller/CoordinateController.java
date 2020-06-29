package com.mufg.coordinateprocessor.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mufg.coordinateprocessor.exception.CoordinatesExceptionResponse;
import com.mufg.coordinateprocessor.exception.CordinateErrorCode;
import com.mufg.coordinateprocessor.exception.CordinateException;
import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.model.Line;
import com.mufg.coordinateprocessor.model.ValidCoordinateList;
import com.mufg.coordinateprocessor.model.ValidCoordinateListMap;
import com.mufg.coordinateprocessor.response.CoordinateResponse;
import com.mufg.coordinateprocessor.response.CoordinateSuccessResponse;
import com.mufg.coordinateprocessor.service.CoordinateLengthService;
import com.mufg.coordinateprocessor.service.CoordinatesLengthCalculatorService;
import com.mufg.coordinateprocessor.util.CoordinateConstants;
import com.mufg.coordinateprocessor.util.CoordinatesValidator;

/**
 * @author AkshayK2
 * Controller Class to Map Coordinate API Calls
 */
@RestController
@RequestMapping("/cordinates")
public class CoordinateController {

	@Autowired
	CoordinatesLengthCalculatorService coordinatesLengthCalculatorService;

	@Autowired
	CoordinateLengthService coordinateLengthService;

	private static final Logger logger = LoggerFactory.getLogger(CoordinateController.class);

	/**
	 * @param inputLinesMap
	 * @return ResponseEntity
	 * Saves Coordinate List to CSV
	 */
	@RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> addLineInput(
			 @RequestBody HashMap<String, ArrayList<Coordinate>> inputLinesMap) {
		logger.info(inputLinesMap.get("Lines").toString());

		CoordinateSuccessResponse coordinateSuccessResponse;
		try {
			CoordinatesValidator.validateBean(inputLinesMap.get("Lines"));
			logger.info("Request Body", inputLinesMap.get("Lines"));
			Integer response = coordinateLengthService.saveToCsv(inputLinesMap.get("Lines"));
			if (response == CoordinateConstants.ZERO_APPENDER) {
				coordinateSuccessResponse = new CoordinateSuccessResponse(HttpStatus.BAD_REQUEST.toString(),
						CordinateErrorCode.DATA_NOT_INSERTED.getErrorName(), new Date());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(coordinateSuccessResponse);
			}

			coordinateSuccessResponse = new CoordinateSuccessResponse(HttpStatus.CREATED.toString(),
					"Data saved to CSV", new Date());
			return ResponseEntity.status(HttpStatus.CREATED).body(coordinateSuccessResponse);
		} catch (CordinateException ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new CoordinatesExceptionResponse(ex.getErrorCode(), ex.getMessage(), new Date()));
		} catch (Exception e) {
			logger.error((e.getStackTrace()[0].getMethodName()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	/**
	 * @return ResponseEntity
	 * Processes the Maximum Coordinate Object
	 */
	@RequestMapping(value = "/getmaxlength", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> calcCordinateDistanceFromCSV() {
		CoordinateSuccessResponse coordinateSuccessResponse;
		try {

			HashMap<Integer, Double> lengthMap = new HashMap<>();
			List<Coordinate> lineList = new ArrayList<Coordinate>();
			lineList = coordinateLengthService.readFromCsv();
			if (!(lineList.size() > 0)) {
				throw new CordinateException(CordinateErrorCode.DATA_NOT_INSERTED);
			}
			for (Coordinate line : lineList) {
				Double lineLen = coordinatesLengthCalculatorService.findLength(line);
				lengthMap.put(line.getLineNumber(), lineLen);
			}
			Entry<Integer, Double> maxDistance = coordinatesLengthCalculatorService.findMaxDistance(lengthMap);
			CoordinateResponse coordinateResponse = new CoordinateResponse(maxDistance.getKey().toString());
			coordinateSuccessResponse = new CoordinateSuccessResponse(HttpStatus.OK.toString(),
					"Data Fetched Sucessfully", coordinateResponse, new Date());
			return ResponseEntity.status(HttpStatus.OK).body(coordinateSuccessResponse);

		} catch (CordinateException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}

	}

	/**
	 * @return ResponseEntity Object
	 * Reads the Coordinates Objects Saved in CSV
	 */
	@RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Object> getLineInput() {
		CoordinateSuccessResponse coordinateSuccessResponse;
		try {

			List<Coordinate> lineList = new ArrayList<Coordinate>();
			lineList = coordinateLengthService.readFromCsv();
			if (!(lineList.size() > CoordinateConstants.ZERO_APPENDER)) {
				throw new CordinateException(CordinateErrorCode.DATA_NOT_INSERTED);
			}
			logger.info(lineList.toString());
			coordinateSuccessResponse = new CoordinateSuccessResponse(HttpStatus.OK.toString(),
					"Data Fetched Sucessfully", lineList, new Date());
			return ResponseEntity.status(HttpStatus.OK).body(coordinateSuccessResponse);

		} catch (CordinateException ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new CoordinatesExceptionResponse(ex.getErrorCode(), ex.getMessage(), new Date()));
		} catch (Exception e) {
			logger.error((e.getStackTrace()[0].getMethodName()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}
