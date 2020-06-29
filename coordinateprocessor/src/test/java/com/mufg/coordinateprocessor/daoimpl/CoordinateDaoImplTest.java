package com.mufg.coordinateprocessor.daoimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mufg.coordinateprocessor.daoImpl.CoordinateLengthDaoImpl;
import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.serviceimpl.CoordinatesLengthCalculatorServiceImplTest;

@SpringBootTest
public class CoordinateDaoImplTest {

	@Autowired
	CoordinateLengthDaoImpl coordinateLengthDaoImpl;

	private static final Logger logger = LoggerFactory.getLogger(CoordinatesLengthCalculatorServiceImplTest.class);

	@Test
	public void saveToCsvTest() {
		logger.info("Test case saveToCsvTest");
		Coordinate line = new Coordinate(1, 10.0f, 5.0f, 13.0f, 9.0f);
		List<Coordinate> cordinateList = new ArrayList<>();
		cordinateList.add(line);
		logger.info(cordinateList.toString());
		assertEquals(1, coordinateLengthDaoImpl.saveToCsv(cordinateList));
	}

	@Test
	public void readFromCsvTest() {
		logger.info("Test case readFromCsv");
		Coordinate line = new Coordinate(1, 10.0f, 5.0f, 13.0f, 9.0f);
		List<Coordinate> cordinateList = new ArrayList<>();
		cordinateList.add(line);
		assertEquals(cordinateList.get(0).getX0(), coordinateLengthDaoImpl.readFromCsv().get(0).getX0());
	}

}
