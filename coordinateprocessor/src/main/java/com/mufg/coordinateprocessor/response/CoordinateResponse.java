package com.mufg.coordinateprocessor.response;

/**
 * @author AkshayK2
 * Response Class for Maximum Coordinate data
 */
public class CoordinateResponse {

	private String longestLine;

	public CoordinateResponse(String longestLine) {
		super();
		this.longestLine = longestLine;
	}

	public String getLongestLine() {
		return longestLine;
	}

}
