package com.employee.exception;

import org.springframework.validation.Errors;

public class BadRequestException extends Exception {

	private String errorCode;
	private String errorMessage;
	private Errors fieldError;

	public BadRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BadRequestException(String errorCode, String errorMessage) {
		super();
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	 
	}
	public BadRequestException(String errorCode, Errors fieldError) {
		super();
		this.errorCode=errorCode;
		this.fieldError=fieldError;
	 
	}
	
	public Errors getFieldError() {
		return fieldError;
	}
	public void setFieldError(Errors fieldError) {
		this.fieldError = fieldError;
	}
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



 
	
	
	

}
