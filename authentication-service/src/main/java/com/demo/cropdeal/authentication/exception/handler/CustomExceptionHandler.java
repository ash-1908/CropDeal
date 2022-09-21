package com.demo.cropdeal.authentication.exception.handler;

import com.demo.cropdeal.authentication.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler (InvalidCredentialsException.class)
	public ResponseEntity<CustomExceptionBody> invalidCredentialsExceptionHandler (InvalidCredentialsException ex, HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler (InvalidPasswordException.class)
	public ResponseEntity<CustomExceptionBody> invalidPasswordExceptionHandler (InvalidPasswordException ex, HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler (UserAlreadyExistsException.class)
	public ResponseEntity<CustomExceptionBody> userAlreadyExistsExceptionHandler (UserAlreadyExistsException ex, HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
	}

	@ExceptionHandler (UserNotFoundException.class)
	public ResponseEntity<CustomExceptionBody> userNotFoundExceptionHandler (UserNotFoundException ex, HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler (InvalidSessionException.class)
	public ResponseEntity<CustomExceptionBody> invalidSessionExceptionHandler (InvalidSessionException ex,
	                                                                    HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
	
	@ExceptionHandler (Exception.class)
	public ResponseEntity<CustomExceptionBody> generalExceptionHandler (Exception ex,
	                                                                           HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
