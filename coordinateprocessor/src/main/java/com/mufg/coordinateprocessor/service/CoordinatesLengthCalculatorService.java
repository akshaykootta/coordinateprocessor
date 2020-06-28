package com.mufg.coordinateprocessor.service;

import java.util.HashMap;
import java.util.Map.Entry;

import com.mufg.coordinateprocessor.exception.CordinateException;
import com.mufg.coordinateprocessor.model.Coordinate;

public interface CoordinatesLengthCalculatorService {
	
	public Double findLength(Coordinate line) throws CordinateException;
	
	public Entry<Integer, Double> findMaxDistance(HashMap<Integer, Double> lengthMap) throws CordinateException;

}
