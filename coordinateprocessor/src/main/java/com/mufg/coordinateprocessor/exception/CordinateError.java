/**
 * 
 */
package com.mufg.coordinateprocessor.exception;

import java.util.HashMap;
import java.util.Map;

public class CordinateError {
	
	private String code;
	private String name;
	private String severity;
	private String message;
	private Map<String, String> details= new HashMap<String, String>();  
	
	public CordinateError(CordinateErrorCode error, String severity, String message, Map<String, String> details) {
		// TODO Auto-generated constructor stub
		this.code = error.getErrorCode();
		this.name = error.getErrorName();
		this.severity = severity;
		this.message = message;
		this.details = details;	 
	}
	
	// Newly Added to convert the Data Service Response to VHQ Response
	public CordinateError(String code,String name, String severity, String message, Map<String, String> details) {
		// TODO Auto-generated constructor stub
		this.code =code;
		this.name = name;
		this.severity = severity;
		this.message = message;
		this.details = details;		
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getDetails() {
		return details;
	}

	public void setDetails(Map<String, String> details) {
		this.details = details;
	}

}
