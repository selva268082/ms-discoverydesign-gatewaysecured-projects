package com.employee.exceptionhandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.employee.exception.BadRequestException;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Map<String, List<Map<String, String>>>> exceptionHandler(
			BadRequestException badRequestException) {
		Map<String, List<Map<String, String>>> responseMap = new HashMap<String, List<Map<String, String>>>();
		List<Map<String, String>> errorLst = badRequestException.getFieldError().getFieldErrors().stream()
				.map((fieldError) -> {
					Map<String, String> errorMap = new HashMap<String, String>();
					String code = fieldError.getCode();
					String message = fieldError.getField();
					errorMap.put(code, message);
					return errorMap;
				}).collect(Collectors.toList());
		responseMap.put("RequestError", errorLst);
		return new ResponseEntity<Map<String, List<Map<String, String>>>>(responseMap, HttpStatus.BAD_REQUEST);
	}
}
