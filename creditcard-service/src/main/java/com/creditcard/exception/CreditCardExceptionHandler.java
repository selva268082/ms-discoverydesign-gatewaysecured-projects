package com.creditcard.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.creditcard.bean.CreditCardNumberException;

@ControllerAdvice
public class CreditCardExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CreditCardNumberException.class)
	public ResponseEntity<Map<String,String>> invalidRequest(CreditCardNumberException creditCardNumberException)
	{
		Map<String,String> errorMap=new HashMap<String,String>();
		errorMap.put(creditCardNumberException.getErrorCode(), creditCardNumberException.getErrorMessage());
		return new  ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST );
	}
	
	
	
}
