package com.mufg.coordinateprocessor.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.mufg.coordinateprocessor.model.Coordinate;

@SpringBootTest
public class CoordinatesValidatorTest {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CoordinatesValidatorTest.class);

	
	@Test
	public void validateBeanTest() throws Exception  {
		logger.info("Test case validateBean");
		Coordinate line=new Coordinate(1, 2.0f, 5.0f, 13.0f, 9.0f);
		List<Coordinate> cordinateList=new ArrayList<>();
		cordinateList.add(line);
		assertEquals(true, CoordinatesValidator.validateBean(cordinateList));
	}

}
