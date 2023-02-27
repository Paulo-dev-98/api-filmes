package com.filme.openapigenerator.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.filme.openapigenerator.exception.CampoException;
import com.filme.openapigenerator.exception.ErrorMessage;
import com.filme.openapigenerator.exception.ResourceNotFoundException;

@RestControllerAdvice
public class Advice {
	
	  @ExceptionHandler(Exception.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return message;
	  }

	  @ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return message;
	  }
	  
	  @ExceptionHandler(CampoException.class)
	  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	  public ErrorMessage campoNomeException(CampoException ex, WebRequest request) {
		  ErrorMessage message = new ErrorMessage(
				  HttpStatus.BAD_REQUEST.value(),
				  new Date(),
				  ex.getMessage(),
				  request.getDescription(false));
		  
		  return message;
	  }
}
