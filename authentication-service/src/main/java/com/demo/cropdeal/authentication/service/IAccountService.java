package com.demo.cropdeal.authentication.service;


import com.demo.cropdeal.authentication.model.Account;
import com.demo.cropdeal.authentication.model.MyRequestModel;
import com.demo.cropdeal.authentication.model.MyResponseModel;

interface IAccountService {
//	INTERFACE WITH NECESSARY METHODS
	
	MyResponseModel signInWithEmail(MyRequestModel req);
	
	MyResponseModel signUpWithEmail(MyRequestModel req);
	
	MyResponseModel resetPassword(MyRequestModel req, String resetToken);
	
	String forgotPassword(String url, String email, String method);
	
	MyResponseModel validateToken(String token);
	
	
}
