package com.hotel.management.exception;

import java.util.Map;

public class ErrorResponse {

	private String message;
	private int errorCode;
	private String timeStamp;
	private String details;
	private Map<String, String> Values;

	public Map<String, String> getValues() {
		return Values;
	}

	public void setValues(Map<String, String> values) {
		Values = values;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
