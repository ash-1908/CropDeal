package com.demo.cropdeal.authentication.service;

import com.demo.cropdeal.authentication.dao.IAccountRepository;
import com.demo.cropdeal.authentication.exception.InvalidCredentialsException;
import com.demo.cropdeal.authentication.exception.UserAlreadyExistsException;
import com.demo.cropdeal.authentication.model.Account;
import com.demo.cropdeal.authentication.model.MyRequestModel;
import com.demo.cropdeal.authentication.model.MyResponseModel;
import com.demo.cropdeal.authentication.security.jwt.JwtUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

// testing sign up with email method functionality

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Signup with email service method")
class SignUpTest {
	MyRequestModel req;
	@Mock
	BCryptPasswordEncoder passwordEncoder;
	@Mock
	EmailServiceImpl emailService;
	@Mock
	SmsService smsService;
	@Mock
	JwtUtil jwtUtil;
	@Mock
	IAccountRepository repository;
	@InjectMocks
	AccountServiceImpl serviceClass;
	@BeforeEach
	void setUp() {
		req = new MyRequestModel();
		serviceClass = new AccountServiceImpl(repository, passwordEncoder, emailService, smsService, jwtUtil);
	}
	
	/*
	 * TESTING EXCEPTIONS
	 */

//	InvalidCredentialsException
	
	@Test
	@DisplayName("Test exception for empty email")
	void testEmptyEmail() {
		req.setPassword("test");
		req.setFullName("test");
		req.setActive(Boolean.TRUE);
		req.setRoles("Farmer");
		Assertions.assertThrows(InvalidCredentialsException.class, () -> serviceClass.signUpWithEmail(req),
			"should throw invalid " + "credentials exception");
	}
	
	@Test
	@DisplayName("Test exception for empty password")
	void testEmptyPassword() {
		req.setEmail("test");
		req.setFullName("test");
		req.setActive(Boolean.TRUE);
		req.setRoles("Farmer");
		Assertions.assertThrows(InvalidCredentialsException.class, () -> serviceClass.signUpWithEmail(req),
			"should throw invalid " + "credentials exception");
	}
	
	@Test
	@DisplayName("Test exception for empty fullName")
	void testEmptyFullName() {
		req.setEmail("test");
		req.setPassword("test");
		req.setActive(Boolean.TRUE);
		req.setRoles("Farmer");
		Assertions.assertThrows(InvalidCredentialsException.class, () -> serviceClass.signUpWithEmail(req),
			"should throw invalid " + "credentials exception");
	}

//  UserAlreadyExistsException
	
	@Test
	@DisplayName("Test UserAlreadyExists exception")
	void testUserAlreadyExistsException() {
		req.setEmail("test");
		req.setPassword("test");
		req.setFullName("test");
		req.setActive(Boolean.TRUE);
		req.setRoles("Farmer");
		
		Mockito.when(repository.findByEmail(req.getEmail())).thenReturn(Optional.of(new Account(req)));
		
		Assertions.assertThrows(UserAlreadyExistsException.class, () -> serviceClass.signUpWithEmail(req));
	}
	
	
	/*
	 * Testing successful working of signUpWithEmail method
	 */
	
	@Test
	@DisplayName("Test Signup with email functionality")
	void testSignUpWithEmail() {
		req.setEmail("test");
		req.setPassword("test");
		req.setFullName("test");
		req.setActive(Boolean.TRUE);
		req.setRoles("Farmer");
		
		MyResponseModel res = new MyResponseModel("thisisajwttoken");
		
		Mockito.when(jwtUtil.getUsernameFromToken(Mockito.anyString())).thenReturn("test");
		Assertions.assertAll(() -> Assertions.assertEquals(req.getEmail(), jwtUtil.getUsernameFromToken(res.getJwt())));
	}
}
