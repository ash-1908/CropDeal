package com.demo.cropdeal.authentication.controller;

import com.demo.cropdeal.authentication.model.Account;
import com.demo.cropdeal.authentication.model.MyRequestModel;
import com.demo.cropdeal.authentication.model.MyResponseModel;
import com.demo.cropdeal.authentication.service.AccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

/*
* Testing Rest Controllers
* */

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Auth Rest Controller")
class TestAuthRestController {

	@InjectMocks
	private AuthRestController controller;
	@Mock
	private AccountServiceImpl service;
	
	private MyResponseModel res;
	private MyRequestModel req;

	@BeforeEach
	void init() {
		 res = new MyResponseModel("thisisjwttoken");
		 req = new MyRequestModel();
	}

	@Test
	@DisplayName("Test signup route")
	public void testSignUp() {
		Mockito.when(service.signUpWithEmail(Mockito.any(MyRequestModel.class))).thenReturn(res);
		ResponseEntity<MyResponseModel> res = controller.signUpWithEmail(req);
		Assertions.assertEquals(200, res.getStatusCodeValue());
	}

	@Test
	@DisplayName ("Test successful signin")
	public void testSignIn () {
		Mockito.when(service.signInWithEmail(Mockito.any(MyRequestModel.class))).thenReturn(res);
		ResponseEntity<MyResponseModel> res = controller.signInWithEmail(req);
		Assertions.assertEquals(200, res.getStatusCodeValue());
	}
}
