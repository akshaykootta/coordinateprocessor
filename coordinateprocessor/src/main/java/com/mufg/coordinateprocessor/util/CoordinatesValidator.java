package com.mufg.coordinateprocessor.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mufg.coordinateprocessor.exception.CordinateErrorCode;
import com.mufg.coordinateprocessor.exception.CordinateException;
import com.mufg.coordinateprocessor.model.Coordinate;

/**
 * @author AkshayK2
 * All the validation logic goes here 
 *
 */
public class CoordinatesValidator {

	private static final Logger logger = LoggerFactory.getLogger(CoordinatesValidator.class);

	/**
	 * @param cordinateList
	 * @return
	 * @throws Exception
	 * Checks the Null pointer Cases
	 */
	public static boolean validateBean(List<Coordinate> cordinateList) throws Exception {

		for (Coordinate coordinate : cordinateList) {
			if (null == coordinate.getX0() || null == coordinate.getX1() || null == coordinate.getY0()
					|| null == coordinate.getY1() || null == coordinate.getLineNumber()) {
				logger.error(CordinateErrorCode.ARGUMENT_MISSING.getErrorDesc());
				throw new CordinateException(CordinateErrorCode.ARGUMENT_MISSING);
			}
		}
		logger.info("Validation Passed!");
		return true;
	}
}
