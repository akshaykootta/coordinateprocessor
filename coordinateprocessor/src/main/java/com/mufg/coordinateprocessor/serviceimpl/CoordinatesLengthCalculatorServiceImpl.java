package com.mufg.coordinateprocessor.serviceimpl;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mufg.coordinateprocessor.exception.CordinateErrorCode;
import com.mufg.coordinateprocessor.exception.CordinateException;
import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.service.CoordinatesLengthCalculatorService;
import com.mufg.coordinateprocessor.util.CoordinateConstants;

/**
 * @author AkshayK2
 * Handles the business logics for Coordinate Objects
 */
@Service
public class CoordinatesLengthCalculatorServiceImpl implements CoordinatesLengthCalculatorService {

	private static final Logger logger = LoggerFactory.getLogger(CoordinatesLengthCalculatorServiceImpl.class);

	
	/**
	 * Calculates the length of Coordinate Objects
	 */
	@Override
	public Double findLength(@Valid Coordinate line) throws CordinateException {
		logger.info(line.toString());
		try {
			Float xlength = line.getX1() - line.getX0();
			Float ylength = line.getY1() - line.getY0();
			Double lineLength = Math.sqrt(xlength * xlength + ylength * ylength);

			logger.info("Line length of lineNumner:" + line.getLineNumber() + " = " + lineLength);
			if (!(lineLength > 0)) {
				throw new CordinateException(CordinateErrorCode.LENGTH_CALC_FAILED);
			}
			return lineLength;

		} catch (CordinateException e) {

			logger.error("Line length calcution failed" + e);

		} catch (Exception e) {
			logger.error("Line length calcution failed" + e);
		}
		return null;
	}

	/**
	 * Process and return the line with the largest length
	 */
	@Override
	public Entry<Integer, Double> findMaxDistance(HashMap<Integer, Double> lengthMap) {
		Entry<Integer, Double> maxDistance = null;
		try {
			for (Entry<Integer, Double> entry : lengthMap.entrySet()) {
				if (maxDistance == null || entry.getValue().compareTo(maxDistance.getValue()) > CoordinateConstants.ZERO_APPENDER) {
					maxDistance = entry;
				}

				if (maxDistance.getValue() == null)
					throw new CordinateException(CordinateErrorCode.MAX_CALC_FAILED);
			}
			logger.info("Largest line is LineNumber : " + maxDistance.getKey());
			return maxDistance;
		} catch (CordinateException e) {

			logger.error("Line length calcution failed" + e);

		} catch (Exception e) {
			logger.error("Line length calcution failed" + e);
		}
		return null;
	}

}
