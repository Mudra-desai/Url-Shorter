package com.proptiger.urlshortner.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.proptiger.urlshortner.response.ApiWrapper;

@ControllerAdvice
@EnableWebMvc
public class GlobalResponseHandler extends ResponseEntityExceptionHandler {
	
	  
	
	  @ExceptionHandler(value = {NullPointerException.class ,
	  IllegalStateException.class})
	  
	  protected ResponseEntity<Object> handleConflict( RuntimeException ex,
	  WebRequest request) { String bodyOfResponse = "Null Pointer Exception: Server Error"; return
	  handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
	  HttpStatus.CONFLICT, request); }
	 
	  
	  @ExceptionHandler(value = {DataIntegrityViolationException.class}) protected
	  ResponseEntity<Object> handleConflict1( RuntimeException ex, WebRequest
	  request) { String bodyOfResponse =
	  "Data Integrity Exception. Check input data"; return
	  handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
	  HttpStatus.CONFLICT, request); }
	 
	@ExceptionHandler(value = { ProApiException.class })
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	protected ApiWrapper handleResourceNotAvailableException(ProApiException exception) {
	
		String message = "Hit selfdefined exception class handler";
		if (exception.getMessage() == null) {
			return new ApiWrapper(message);
		}
		else {
			return new ApiWrapper(exception.getMessage());
		}
	}

}
