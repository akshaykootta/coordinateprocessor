package com.mufg.coordinateprocessor.response;

import java.util.Date;

/**
 * @author AkshayK2
 * Response Class for Success Handling
 *
 */
public class CoordinateSuccessResponse {

	private String responseStatus;

	private String message;

	private Date timeStamp;
	
	private Object responseData;

	public CoordinateSuccessResponse(String responseStatus, String message, Date timeStamp) {
		super();
		this.responseStatus = responseStatus;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public CoordinateSuccessResponse(String responseStatus, String message, Object responseData, Date timeStamp) {
		super();
		this.responseStatus = responseStatus;
		this.message = message;
		this.responseData = responseData;
		this.timeStamp = timeStamp;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
