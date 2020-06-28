package com.mufg.coordinateprocessor.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mufg.coordinateprocessor.dao.CoordinateLengthDao;
import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.service.CoordinateLengthService;

@SpringBootTest
public class MockedDaoTest {
	
	
	@Autowired
	private CoordinateLengthService CoordinateLengthService;

	@MockBean
	private CoordinateLengthDao CoordinateLengthDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MockedDaoTest.class);

	@Test
	public void readFromCsvTest() {
		logger.info("readFromCsvTest method");
		when(CoordinateLengthDao.readFromCsv())
				.thenReturn(Stream.of(new Coordinate(0, 10.0f, 5.0f, 13.0f, 9.0f),
						new Coordinate(1, 11.0f, 5.0f, 13.0f, 8.0f),
						new Coordinate(2, 12.0f, 5.0f, 13.0f, 7.0f)).collect(Collectors.toList()));
		assertEquals(3, CoordinateLengthService.readFromCsv().size());
	}
	
	
	@Test
	public void saveToCsvTest() {
		logger.info("saveToCsvTest method");
		List<Coordinate> cordinateList=new ArrayList<Coordinate>();
		cordinateList.add(new Coordinate(1, 10.0f, 5.0f, 13.0f, 9.0f));
		cordinateList.add(new Coordinate(2, 12.0f, 5.0f, 13.0f, 7.0f));
		when(CoordinateLengthDao.saveToCsv(cordinateList))
				.thenReturn(1);
		assertEquals(1, CoordinateLengthService.saveToCsv(cordinateList));
	}

}
