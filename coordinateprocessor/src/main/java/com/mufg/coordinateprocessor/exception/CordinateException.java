package com.mufg.coordinateprocessor.exception;

public class CordinateException extends Exception {

	private static final long serialVersionUID = 123L;
	String errorCode;
	String errorMessage;
	
	public CordinateException(String message, String code) {
		super(message);
		errorMessage = message;
		errorCode = code;		
	}
	
	public CordinateException(CordinateErrorCode errorCode) {
		this(errorCode.getErrorDesc(), errorCode.getErrorCode());
	}
	
	/**
	 * This constructor will add the param String to the Error Description,
	 * for Custom Messages after the Error Description
	 * @param errorCode
	 * @param param
	 */
	public CordinateException(CordinateErrorCode errorCode, String... param) {
		this(String.format(errorCode.getErrorDesc(),param), errorCode.getErrorCode());
	}
	
	public CordinateException(Exception ex) {
		this(ex.getMessage(), "General");
	}

	@Override
	public String toString() {
		return "CordinateException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
	
}
