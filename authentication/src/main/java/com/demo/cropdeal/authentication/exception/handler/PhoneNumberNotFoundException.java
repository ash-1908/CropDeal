package com.demo.cropdeal.authentication.exception.handler;

public class PhoneNumberNotFoundException extends RuntimeException {
	public PhoneNumberNotFoundException() {
	}
	
	public PhoneNumberNotFoundException(String message) {
		super(message);
	}
}
