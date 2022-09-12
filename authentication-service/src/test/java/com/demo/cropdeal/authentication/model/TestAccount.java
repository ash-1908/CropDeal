package com.demo.cropdeal.authentication.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Account model")
class TestAccount {
	@Test
	@DisplayName("Test conversion of MyRequestModel to Account")
	public void testConversion() {
		MyRequestModel req = new MyRequestModel();
		req.email = "test";
		req.password = "test";
		req.fullName = "test";

		Assertions.assertInstanceOf(Account.class, new Account(req));
	}
}
