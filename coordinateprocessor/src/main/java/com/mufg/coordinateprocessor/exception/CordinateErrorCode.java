package com.mufg.coordinateprocessor.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CordinateErrorCode {
	
	ENTITY_NOT_EXIST("5000", "Entity Not Found", "[%s] not found"), 
	DATA_NOT_INSERTED("5001", "CSV File is Empty","Perform Insert Opertation"), 
	MAX_CALC_FAILED("5002", "Maximun length Calculation Failed","Invalid Input Data"), 
	LENGTH_CALC_FAILED("5003","length Calculation Failed","Invalid Input Data"), 
	ARGUMENT_MISSING("5004","Argument Missing","Invalid Input Request Body");
	

	
	
	private static final Map<String, CordinateErrorCode> resourceErrorCodeMap = new HashMap<String, CordinateErrorCode>();

	static {
		for (CordinateErrorCode resourceErrorCode : EnumSet.allOf(CordinateErrorCode.class))
			resourceErrorCodeMap.put(resourceErrorCode.getErrorCode(), resourceErrorCode);
	}

	private String errorCode;
	private String errorName;
	private String errorDesc;

	private CordinateErrorCode(String errorCode, String errorName, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
		this.errorName = errorName;
	}
	
	@Override
	public String toString() { 
		return "{\"errorCode\":"+errorCode + ", \"errorDesc\":\"" + errorDesc+"\"}";
	}

	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorDesc() {
		return errorDesc;
	}
	
	public String getErrorName() {
		return errorName;
	}
	
	public static CordinateErrorCode get(String errorCode) {
		return resourceErrorCodeMap.get(errorCode);
	}

	

		
}
