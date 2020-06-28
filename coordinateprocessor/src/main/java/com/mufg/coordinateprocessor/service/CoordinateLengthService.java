package com.mufg.coordinateprocessor.service;

import java.util.List;

import com.mufg.coordinateprocessor.model.Coordinate;

public interface CoordinateLengthService {

	public Integer saveToCsv(List<Coordinate> cordinateList); 
	
	public List<Coordinate> readFromCsv();
	
	

}
