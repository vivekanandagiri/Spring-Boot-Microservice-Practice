package com.example.exception;


import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {
	//Handles the custom Employee not found exception.
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object>handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request){
		HashMap<String, Object> map = new HashMap<>();
		map.put("timestamp",LocalDateTime.now());
		map.put("status", HttpStatus.NOT_FOUND.value());
		map.put("error","Not Found");
		map.put("message", ex.getMessage());
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	// Handles other generic exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGlobalException(Exception ex,WebRequest request){
		HashMap<Object, Object> map = new HashMap<>();
		map.put("timestamp",LocalDateTime.now());
		map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		map.put("error","Internal Server Error..");
		map.put("message","An unexpected Error Occured:"+ex.getMessage());
		
		return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
