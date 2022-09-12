//package com.cg.cropdeal.authentication.controller;
//
//import com.cg.cropdeal.authentication.model.Account;
//import com.cg.cropdeal.authentication.model.AccountRequestModel;
//import com.cg.cropdeal.authentication.service.AccountServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//@DisplayName("Test Auth Rest Controller")
//class TestAuthRestController {
//
//	@InjectMocks
//	private AuthRestController controller;
//	@Mock
//	private AccountServiceImpl service;
//
//	@BeforeEach
//	void init() {
//		Account account = new Account("test", "test", "test");
//		AccountRequestModel req = new AccountRequestModel();
//	}
//
//	@Test
//	@DisplayName("Test signup route")
//	public void testSignUp() {
////		Mockito.when(service.signUpWithEmail(Mockito.any(AccountRequestModel.class))).thenReturn();
////		ResponseEntity<Account> res = controller.signUpWithEmail(req);
////		Assertions.assertEquals(200, res.getStatusCodeValue());
//	}
//
////	@Test
////	@DisplayName ("Test successful signin")
////	public void testSignIn () {
////		Mockito.when(service.signInWithEmail(Mockito.any(Account.class))).thenReturn(account);
////		ResponseEntity<Account> res = controller.signInWithEmail(req);
////		Assertions.assertEquals(200, res.getStatusCodeValue());
////	}
//}
