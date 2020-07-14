package com.hotel.management.exception;

import java.util.Map;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	private Map<String, String> value;

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message, Map<String, String> value) {
		this.message = message;
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getValue() {
		return value;
	}

	public void setValue(Map<String, String> value) {
		this.value = value;
	}

}
