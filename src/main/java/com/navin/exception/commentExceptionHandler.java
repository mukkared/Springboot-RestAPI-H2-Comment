package com.navin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class commentExceptionHandler {

	@ExceptionHandler(value = { commentNotFoundException.class })
	public ResponseEntity<Object> handleCommentNotFoundException(commentNotFoundException commentNotFoundException) {
		commentException commentException = new commentException(commentNotFoundException.getMessage(),
				commentNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(commentException, HttpStatus.NOT_FOUND);
	}

}
