package com.mufg.coordinateprocessor.model;

import java.util.ArrayList;
import java.util.Map;

import javax.validation.Valid;

public class ValidCoordinateListMap<T,V>{
	
	@Valid
	private Map<Line,ArrayList<Coordinate>> Lines ;

	
	public ValidCoordinateListMap() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Map<Line, ArrayList<Coordinate>> getLines() {
		return Lines;
	}


	public void setLines(Map<Line, ArrayList<Coordinate>> lines) {
		Lines = lines;
	}


	public ValidCoordinateListMap(@Valid Map<Line, ArrayList<Coordinate>> lines) {
		super();
		Lines = lines;
	}


	@Override
	public String toString() {
		return "ValidCoordinateListMap [Lines=" + Lines + "]";
	}


	
	

	



	

	
}
