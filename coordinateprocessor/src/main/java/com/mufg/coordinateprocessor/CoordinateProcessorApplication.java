package com.mufg.coordinateprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoordinateProcessorApplication{
	
	   private static final Logger logger = LoggerFactory.getLogger(CoordinateProcessorApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CoordinateProcessorApplication.class, args);
		logger.info("Beans loaded and Application started succesfully!!");
		
	}
}
