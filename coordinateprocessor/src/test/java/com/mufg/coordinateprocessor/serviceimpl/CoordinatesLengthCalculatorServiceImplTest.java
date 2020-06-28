package com.mufg.coordinateprocessor.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mufg.coordinateprocessor.exception.CordinateException;
import com.mufg.coordinateprocessor.model.Coordinate;

@SpringBootTest
public class CoordinatesLengthCalculatorServiceImplTest {

	@Autowired
	CoordinatesLengthCalculatorServiceImpl CoordinatesLengthCalculatorServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(CoordinatesLengthCalculatorServiceImplTest.class);

	@Test
	public void findLengthTest() throws CordinateException {
		logger.info("Test case findLength");
		Coordinate line = new Coordinate(1, 10.0f, 5.0f, 13.0f, 9.0f);
		assertEquals(5.0f, CoordinatesLengthCalculatorServiceImpl.findLength(line));
	}

	@Test
	public void findMaxDistanceTest() {
		logger.info("Test case findLength");
		HashMap<Integer, Double> lengthMap = new HashMap<>();
		lengthMap.put(0, 100.0);
		lengthMap.put(1, 200.0);
		lengthMap.put(2, 300.0);
		assertEquals(lengthMap.get(2), CoordinatesLengthCalculatorServiceImpl.findMaxDistance(lengthMap).getValue());
	}

}
