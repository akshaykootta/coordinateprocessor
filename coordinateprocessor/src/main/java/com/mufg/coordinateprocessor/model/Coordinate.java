package com.mufg.coordinateprocessor.model;

import com.opencsv.bean.CsvBindByPosition;


/**
 * @author AkshayK2
 * Model Class which Maps the Input Request and Mapper Class for Writing and Reading from CSV
 */
public class Coordinate {

	@CsvBindByPosition(position = 0)
	private Integer lineNumber;
	
	@CsvBindByPosition(position = 1)
	private Float x0;

	@CsvBindByPosition(position = 2)
	private Float y0;

	@CsvBindByPosition(position = 3)
	private Float x1;
	
	@CsvBindByPosition(position = 4)
	private Float y1;

	public Coordinate() {
		super();

	}

	public Coordinate(Integer lineNumber, Float x0, Float y0, Float x1, Float y1) {
		super();
		this.lineNumber = lineNumber;
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public Float getX0() {
		return x0;
	}
	public void setX0(Float x0) {
		this.x0 = x0;
	}

	public Float getY0() {
		return y0;
	}
	public void setY0(Float y0) {
		this.y0 = y0;
	}

	public Float getX1() {
		return x1;
	}
	public void setX1(Float x1) {
		this.x1 = x1;
	}

	public Float getY1() {
		return y1;
	}
	public void setY1(Float y1) {
		this.y1 = y1;
	}

	@Override
	public String toString() {
		return "Line [lineNumber=" + lineNumber + ", x0=" + x0 + ", y0=" + y0 + ", x1=" + x1 + ", y1=" + y1 + "]";
	}

}
