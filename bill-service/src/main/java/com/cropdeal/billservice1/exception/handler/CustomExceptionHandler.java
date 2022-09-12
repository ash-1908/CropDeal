package com.cropdeal.billservice1.exception.handler;

/*import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cropdeal.billservice1.exception.BillidAreadyExistsException;
import com.cropdeal.billservice1.exception.BillidNotFoundException;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	

	@ExceptionHandler (BillidAreadyExistsException.class)
	public ResponseEntity<CustomExceptionBody> BillidAlreadyExistsExceptionHandler (BillidAreadyExistsException ex, HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
	}

	@ExceptionHandler (BillidNotFoundException.class)
	public ResponseEntity<CustomExceptionBody> BillidNotFoundExceptionHandler (BillidNotFoundException ex, HttpServletRequest req) {
		CustomExceptionBody exception = new CustomExceptionBody(ex.getMessage(), req.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
}
*/
