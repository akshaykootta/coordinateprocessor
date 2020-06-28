package com.mufg.coordinateprocessor.exception;

import java.util.Date;


/**
 * @author AkshayK2
 * Creates the responses for Exceptions
 *
 */
public class CoordinatesExceptionResponse{
	
	
	private String errorCode;

	private String errorMessage;
	
	private Date timeStamp;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "CoordinatesExceptionResponse [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", timeStamp="
				+ timeStamp + "]";
	}

	public CoordinatesExceptionResponse(String errorCode, String errorMessage, Date timeStamp) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}

	
	
	

}
