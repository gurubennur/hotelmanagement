package com.hotel.management.exception;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HotelManageMentExceptionController {

	ErrorResponse response = new ErrorResponse();

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ErrorResponse exception(ConstraintViolationException exception) {

		response.setMessage(exception.getMessage());
		response.setErrorCode(HttpStatus.BAD_REQUEST.value());
		response.setDetails(HttpStatus.BAD_REQUEST.getReasonPhrase());
		response.setTimeStamp(LocalDateTime.now().toString());
		return response;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ErrorResponse exception(MethodArgumentNotValidException exception) {

		response.setMessage(exception.getMessage());
		response.setErrorCode(HttpStatus.BAD_REQUEST.value());
		response.setDetails(HttpStatus.BAD_REQUEST.getReasonPhrase());
		response.setTimeStamp(LocalDateTime.now().toString());
		return response;
	}

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ErrorResponse exception(CustomerNotFoundException exception) {

		response.setMessage(exception.getMessage());
		response.setErrorCode(HttpStatus.NOT_FOUND.value());
		response.setDetails(HttpStatus.NOT_FOUND.getReasonPhrase());
		response.setTimeStamp(LocalDateTime.now().toString());
		response.setValues(exception.getValue());
		return response;
	}

	@ExceptionHandler(value = BusinessException.class)
	public ErrorResponse exception(BusinessException exception) {

		response.setMessage(exception.getMessage());
		response.setErrorCode(HttpStatus.BAD_REQUEST.value());
		response.setDetails(HttpStatus.BAD_REQUEST.getReasonPhrase());
		response.setTimeStamp(LocalDateTime.now().toString());
		response.setValues(exception.getValue());
		return response;
	}

}
