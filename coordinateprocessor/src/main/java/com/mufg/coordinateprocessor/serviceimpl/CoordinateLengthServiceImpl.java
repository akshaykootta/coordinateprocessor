package com.mufg.coordinateprocessor.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mufg.coordinateprocessor.dao.CoordinateLengthDao;
import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.service.CoordinateLengthService;

/**
 * @author AkshayK2
 *Service class for CRUD Operations
 */
@Service
public class CoordinateLengthServiceImpl implements CoordinateLengthService{
	
	
	@Autowired
	CoordinateLengthDao CoordinateLengthDaoImpl;

	
	/**
	 * Saves file to CSV
	 */
	@Override
	public Integer saveToCsv(List<Coordinate> cordinateList) {
		return CoordinateLengthDaoImpl.saveToCsv(cordinateList);
		
	}


	/**
	 * Reads files from CSV
	 */
	@Override
	public List<Coordinate> readFromCsv() {
		return CoordinateLengthDaoImpl.readFromCsv();
	}
	
	
	
	
	
	

}
