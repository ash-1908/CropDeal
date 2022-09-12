package com.demo.cropdeal.authentication.exception;

public class InvalidSessionException extends RuntimeException {
	public InvalidSessionException() {
		super();
	}
	
	public InvalidSessionException(String message) {
		super(message);
	}
}
