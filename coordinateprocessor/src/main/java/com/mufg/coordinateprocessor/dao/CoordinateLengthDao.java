package com.mufg.coordinateprocessor.dao;

import java.util.List;

import com.mufg.coordinateprocessor.model.Coordinate;

public interface CoordinateLengthDao {


	public List<Coordinate> readFromCsv();

	public Integer saveToCsv(List<Coordinate> cordinateList);

}
