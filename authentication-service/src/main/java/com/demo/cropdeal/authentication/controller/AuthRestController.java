package com.demo.cropdeal.authentication.controller;

import com.demo.cropdeal.authentication.model.MyRequestModel;
import com.demo.cropdeal.authentication.model.MyResponseModel;
import com.demo.cropdeal.authentication.security.MyAuthenticationManager;
import com.demo.cropdeal.authentication.security.jwt.JwtUtil;
import com.demo.cropdeal.authentication.service.AccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

// rest controller class for authentication microservice
@RestController
public class AuthRestController {
	
	private final MyAuthenticationManager myAuthenticationManager;
	private final JwtUtil jwtUtil;
	private final AccountServiceImpl accountServiceImpl;
	
	
	@Autowired
	public AuthRestController(MyAuthenticationManager myAuthenticationManager, JwtUtil jwtUtil,
	                          AccountServiceImpl accountServiceImpl) {
		this.myAuthenticationManager = myAuthenticationManager;
		this.jwtUtil = jwtUtil;
		this.accountServiceImpl = accountServiceImpl;
	}


//	SIGN UP EMAIL
	
	@Operation(summary = "Sign up using email", description = "User can sign up using an email, password, and full name" +
		". On successful sign in, this route returns a jwt token.", tags = {"Sign up"})
	@PostMapping("/signup")
	public ResponseEntity<MyResponseModel> signUpWithEmail(@RequestBody MyRequestModel req) {
		
		return new ResponseEntity<>(accountServiceImpl.signUpWithEmail(req), HttpStatus.OK);
	}

//	SIGN IN EMAIL
	
	@Operation(summary = "Sign in using email", description = "User can sign in using an email and password. On " +
		"successful sign in, this route returns a jwt token.", tags = {"Sign in"})
	@PostMapping("/signin")
	public ResponseEntity<MyResponseModel> signInWithEmail(@RequestBody MyRequestModel req) {
		
		return new ResponseEntity<>(accountServiceImpl.signInWithEmail(req), HttpStatus.OK);
	}
	
	//	FORGOT PASSWORD
	@Operation(summary = "Forgot password",
		description = "This route is for password reset. User will be validated and " + "given options for resetting.",
		tags = {"Reset password"})
	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(HttpServletRequest req, @RequestParam String email,
	                                             @RequestParam String method) {
		
		return ResponseEntity.ok(accountServiceImpl.forgotPassword(req.getRequestURL().toString(), email, method));
	}
	
	
	//	RESET PASSWORD
	@Operation(summary = "Reset password", description = "This route is for password reset", tags = {"Reset password"})
	@PostMapping("/forgot-password/reset")
	public ResponseEntity<MyResponseModel> resetPassword(@RequestBody MyRequestModel req,
	                                                     @RequestParam String resetToken) {
		
		return ResponseEntity.ok(accountServiceImpl.resetPassword(req, resetToken));
	}
	
	//	VALIDATE OTP
	@Operation(summary = "Validate OTP", description = "This route is for password reset using SMS.",
		tags = {"Reset " + "password"})
	@PostMapping("/otp-reset")
	public ResponseEntity<Boolean> validateOTP(@RequestBody MyRequestModel req) {
		
		return ResponseEntity.ok(accountServiceImpl.validateOTP(req));
	}
	
	@PostMapping("/validate-token")
	public ResponseEntity<MyResponseModel> validateToken(@RequestParam String token) {
		return ResponseEntity.ok(accountServiceImpl.validateToken(token));
	}
}
