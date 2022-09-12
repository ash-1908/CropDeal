package com.demo.cropdeal.authentication.service;

import com.demo.cropdeal.authentication.dao.IAccountRepository;
import com.demo.cropdeal.authentication.exception.InvalidCredentialsException;
import com.demo.cropdeal.authentication.exception.UserNotFoundException;
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

/*
testing sign in with email method functionality
*/
@ExtendWith(MockitoExtension.class)
@DisplayName("Test Signin with email service method")
class SignInTest {
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
	AccountServiceImpl service;
	@BeforeEach
	void setUp() {
		req = new MyRequestModel();
		service = new AccountServiceImpl(repository, passwordEncoder, emailService, smsService, jwtUtil);
	}

	//	********** testing InvalidCredentialsException *******************
	@Test
	@DisplayName("Test empty email")
	void testEmptyEmail() {
		req.setPassword("test");
		Assertions.assertThrows(InvalidCredentialsException.class, () -> service.signInWithEmail(req),
			"should throw invalid credentials exception");
	}

	@Test
	@DisplayName("Test empty password")
	void testEmptyPassword() {
		req.setEmail("test");
		Assertions.assertThrows(InvalidCredentialsException.class, () -> service.signInWithEmail(req),
			"should throw invalid credentials exception");
	}

	// ********* testing UserNotFoundException exception **************
	@Test
	@DisplayName("Test UserNotFoundException exception")
	void testUserNotFoundException() {
		req.setEmail("test");
		req.setPassword("test");

		Assertions.assertThrows(UserNotFoundException.class,
			() -> service.signInWithEmail(req));
	}

	//	********** testing successful sign in with email functionality **********
	@Test
	@DisplayName("Test Signin with email functionality")
	void testSignInWithEmail() {
		req.setEmail("test");
		req.setPassword("test");

		Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(new Account(req)));
		Mockito.when(passwordEncoder.matches(Mockito.anyString(), Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(jwtUtil.generateToken(Mockito.any(Account.class))).thenReturn("thisisjwttoken");
		MyResponseModel res = service.signInWithEmail(req);
		
		Assertions.assertEquals(res.getJwt().getClass(), String.class);
		
	}
}

