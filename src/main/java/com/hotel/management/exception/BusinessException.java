package com.hotel.management.exception;

import java.util.Map;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	private Map<String, String> values;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Map<String, String> values) {
		this.message = message;
		this.values = values;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getValue() {
		return values;
	}

	public void setValue(Map<String, String> values) {
		this.values = values;
	}
}
