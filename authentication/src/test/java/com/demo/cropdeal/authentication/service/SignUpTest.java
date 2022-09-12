//package com.cg.cropdeal.authentication.service;
//
//import com.cg.cropdeal.authentication.dao.IAccountRepository;
//import com.cg.cropdeal.authentication.model.Account;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//// testing sign up with email method functionality
//
//@ExtendWith(MockitoExtension.class)
//@DisplayName("Test Signup with email service method")
//class SignUpTest {
//	Account account;
//	@InjectMocks
//	AccountServiceImpl serviceClass = new AccountServiceImpl();
//
//	@Mock
//	IAccountRepository accountRepo;
//
//	@BeforeEach
//	void setUp() {
//		account = new Account();
//	}
//
//	//*******	testing InvalidCredentialsException.class *************
//
//	@Test
//	@DisplayName("Test exception for empty email")
//	void testEmptyEmail() {
//		account.setPassword("test");
//		account.setFullName("test");
////		Assertions.assertThrows(InvalidCredentialsException.class,
////		 () -> serviceClass.signUpWithEmail(account), "should throw invalid " +
////			"credentials exception");
//	}
//
//	@Test
//	@DisplayName("Test exception for empty password")
//	void testEmptyPassword() {
//		account.setUserName("test");
//		account.setFullName("test");
////		Assertions.assertThrows(InvalidCredentialsException.class,
////		 () -> serviceClass.signUpWithEmail(account), "should throw invalid " +
////			"credentials exception");
//	}
//
//	@Test
//	@DisplayName("Test exception for empty fullName")
//	void testEmptyFullName() {
//		account.setUserName("test");
//		account.setPassword("test");
////		Assertions.assertThrows(InvalidCredentialsException.class,
////		 () -> serviceClass.signUpWithEmail(account), "should throw invalid " +
////			"credentials exception");
//	}
//
//	// ************* testing UserAlreadyExistsExcepton *******************
//
//	@Test
//	@DisplayName("Test UserAlreadyExists exception")
//	void testUserAlreadyExistsException() {
//		account.setUserName("test");
//		account.setPassword("test");
//		account.setFullName("test");
//
//		Mockito.when(accountRepo.findByUserName(Mockito.anyString())).thenReturn(account);
////		Assertions.assertThrows(UserAlreadyExistsException.class,
////		 () -> serviceClass.signUpWithEmail(account));
//	}
//
//
//	// ************** testing successful sign up with email functionality *****
//	@Test
//	@DisplayName("Test Signup with email functionality")
//	void testSignUpWithEmail() {
//		account.setUserName("test");
//		account.setPassword("test");
//		account.setFullName("test");
//
//
////		Account returnedAccountInfo = serviceClass.signUpWithEmail(account);
//
//
////		Assertions.assertAll(
////		 () -> Assertions.assertEquals(account.getUserName(),
////			returnedAccountInfo.getUserName()),
////		 () -> Assertions.assertNull(returnedAccountInfo.getPassword()),
////		 () -> Assertions.assertEquals(account.getFullName(),
////			returnedAccountInfo.getFullName())
////		);
//	}
//}
