package com.mufg.coordinateprocessor.model;

import java.util.List;

import javax.validation.Valid;

public class ValidCoordinateList<T> {

	@Valid
	private List<T> cordinateList;

	public List<T> getCordinateList() {
		return cordinateList;
	}

	public void setCordinateList(List<T> cordinateList) {
		this.cordinateList = cordinateList;
	}

	public ValidCoordinateList(List<T> cordinateList) {
		super();
		this.cordinateList = cordinateList;
	}

	public ValidCoordinateList() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
