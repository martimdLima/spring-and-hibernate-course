package com.martimlima.springdemo.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {
		
		// create a CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), 
															    ex.getMessage(), 
															    System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another ExceptionHandler to catch general Exceptions
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {
		
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), 
																ex.getMessage(), 
																System.currentTimeMillis());

		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
