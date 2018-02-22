package com.mdhyani.spring.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mdhyani.spring.model.ErrorMessage;


@ControllerAdvice
public class RestExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(Throwable.class)
	protected ResponseEntity<Object> handleEntityNotFound(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage(ex.getMessage());
		errorMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		LOG.debug("Error : "+ex.getCause());
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
