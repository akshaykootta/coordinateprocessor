package com.mufg.coordinateprocessor.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.service.CoordinateLengthService;

@SpringBootTest
public class MockedServiceTest {

	@Autowired
	private CoordinateController coordinateController;

	@MockBean
	private  CoordinateLengthService coordinateLengthService;

	private static final Logger logger = LoggerFactory.getLogger(MockedServiceTest.class);

	@Test
	public void getInputTest() {
		logger.info("getInputTest method");
		when(coordinateLengthService.readFromCsv()).thenReturn(
				Stream.of(new Coordinate(0, 10.0f, 5.0f, 13.0f, 9.0f), new Coordinate(1, 11.0f, 5.0f, 13.0f, 8.0f),
						new Coordinate(2, 12.0f, 5.0f, 13.0f, 7.0f)).collect(Collectors.toList()));
		assertEquals(true, coordinateController.getLineInput().getBody().toString().contains("lineNumber"));
	}

	@Test
	public void saveToCsvTest() {
		logger.info("saveToCsvTest method");
		List<Coordinate> cordinateList = new ArrayList<Coordinate>();
		cordinateList.add(new Coordinate(0, 10.0f, 5.0f, 13.0f, 9.0f));
		cordinateList.add(new Coordinate(3, 12.0f, 5.0f, 13.0f, 7.0f));
		 HashMap<String, ArrayList<Coordinate>> hm = new HashMap<String, ArrayList<Coordinate>>();
		when(coordinateLengthService.saveToCsv(cordinateList)).thenReturn(1);
		assertEquals(HttpStatus.BAD_REQUEST, coordinateController.addLineInput(hm).getStatusCode());
	}

}
