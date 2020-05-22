package com.mobile.ws.controllers.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mobile.ws.model.response.ErrorMessage;

@ControllerAdvice
public class AppManagerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		String descError = ex.getLocalizedMessage();
		if (descError == null) descError = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), descError);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		//return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullException(NullPointerException ex, WebRequest request){
		String descError = ex.getLocalizedMessage();
		if (descError == null) descError = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), descError);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		//return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleServiceException(UserServiceException ex, WebRequest request){
		String descError = ex.getLocalizedMessage();
		if (descError == null) descError = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), descError);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		//return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	@ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleNullException(Exception ex, WebRequest request){
		String descError = ex.getLocalizedMessage();
		if (descError == null) descError = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), descError);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		//return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
