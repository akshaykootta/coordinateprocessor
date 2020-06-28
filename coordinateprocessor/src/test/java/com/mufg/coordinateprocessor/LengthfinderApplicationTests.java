package com.mufg.coordinateprocessor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mufg.coordinateprocessor.controller.CoordinateController;



@SpringBootTest
class LengthfinderApplicationTests {
	
	
	@Autowired
	private CoordinateController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	
}