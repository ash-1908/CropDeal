package com.demo.cropdeal.authentication.service;

import com.demo.cropdeal.authentication.dao.IAccountRepository;
import com.demo.cropdeal.authentication.exception.*;
import com.demo.cropdeal.authentication.exception.handler.PhoneNumberNotFoundException;
import com.demo.cropdeal.authentication.model.Account;
import com.demo.cropdeal.authentication.model.MyRequestModel;
import com.demo.cropdeal.authentication.model.MyResponseModel;
import com.demo.cropdeal.authentication.security.jwt.JwtUtil;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountServiceImpl implements UserDetailsService, IAccountService {
	private final IAccountRepository repository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final EmailServiceImpl emailService;
	private final SmsService smsService;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public AccountServiceImpl(IAccountRepository repository, BCryptPasswordEncoder passwordEncoder,
	                          EmailServiceImpl emailService, SmsService smsService, JwtUtil jwtUtil) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.emailService = emailService;
		this.smsService = smsService;
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
		Account user = repository.findByEmail(email);
		if (user == null) {
			throw new UserNotFoundException("User not found with given email: " + email);
		}
		return user;
	}
	
	@Override
	public MyResponseModel signUpWithEmail(MyRequestModel req) {
		if (!req.signUpValidation()) {
			throw new InvalidCredentialsException("Field(s) cannot be empty.");
		}
		
		// check if account object already exist in database
		Account dataFromDb = repository.findByEmail(req.getEmail());
		if (Objects.isNull(dataFromDb)) {
			// if account object doesn't already exist in database
			// save the account object into database
			String encryptedPwd = passwordEncoder.encode(req.getPassword());
			req.setPassword(encryptedPwd);
			Account account = new Account(req);
			repository.save(account);
			String JWT_TOKEN = jwtUtil.generateToken(account);
			return new MyResponseModel(JWT_TOKEN);
		}
		// if account object already exist in database throw exception
		throw new UserAlreadyExistsException("User account already exists.");
	}
	
	@Override
	public MyResponseModel signInWithEmail(MyRequestModel req) {
		// check for empty values in account object
		if (!req.signInValidation()) {
			throw new InvalidCredentialsException("Email/Password field(s) cannot be empty.");
		}
		
		// check if account object exist in database
		Account account = repository.findByEmail(req.getEmail());
		if (!Objects.isNull(account)) {
			// check if password is correct
			if (passwordEncoder.matches(req.getPassword(), account.getPassword())) {
				String JWT_TOKEN = jwtUtil.generateToken(account);
				return new MyResponseModel(JWT_TOKEN);
			}
			// throw exception if password is wrong
			throw new InvalidPasswordException("Invalid password.");
		}
		// throw exception if account object is not in database
		throw new UserNotFoundException("User does not exist.");
	}
	
	
	public Boolean validateOTP(MyRequestModel req) {
		String otp = req.getResetCode();
		if (otp != null && !otp.isBlank()) {
			Account account = repository.findByResetCode(otp);
			return account != null;
		}
		return false;
	}
	
	@Override
	public MyResponseModel resetPassword(MyRequestModel req, String resetToken) {
		if (!req.resetPasswordValidation()) {
			throw new InvalidCredentialsException("Password/Reset-token field(s) cannot be empty.");
		}
		
		String password = req.getPassword();
		
		Account account = repository.findByResetCode(resetToken);
		
		if (account != null && account.getResetCode().equals(resetToken)) {
			String encryptedPassword = passwordEncoder.encode(password);
			account.setPassword(encryptedPassword);
			account.setResetCode(null);
			repository.save(account);
			String JWT_TOKEN = jwtUtil.generateToken(account);
			return new MyResponseModel(JWT_TOKEN);
		}
		
		throw new InvalidSessionException("Invalid session. Please try " + "again later.");
	}
	
	@Override
	public String forgotPassword(String url, String email, String method) {
		if (email == null || email.isBlank()) throw new InvalidCredentialsException("Email field cannot be empty.");
		
		Account account = repository.findByEmail(email);
		
		if (account == null) throw new UserNotFoundException("User with email: " + email + " not found.");

//		if method value is otp, only then we will send sms, else we will send email
		if (method.equalsIgnoreCase("otp")) {
			
			if (account.getPhoneNumber() == null) throw new PhoneNumberNotFoundException("Phone number not found.");
			
			Double otp = Math.floor(Math.random() * 10000 + Math.random() * 1000 + Math.random() * 100 + Math.random() * 10);
			
			account.setResetCode(otp.toString());
			repository.save(account);
			
			smsService.sendOTP(account.getPhoneNumber(), otp.toString());
			
			return "Sms sent.";
		} else {
			final String resetCode = RandomString.make(20);
			
			account.setResetCode(resetCode);
			repository.save(account);
			
			final String link = url + "/reset?token=" + resetCode;
			
			emailService.resetPasswordMail(account.getUsername(), account.getFullName(), link);
			
			return "Email sent.";
		}
	}
	
	@Override
	//	helper method for api gateway to validate token
	public MyResponseModel validateToken(String token) {
		if (token == null || token.isBlank()) throw new InvalidCredentialsException("Token cannot be empty.");
//		get the subject from token
		String subject = jwtUtil.getUsernameFromToken(token);
//		fetch the data from backend
		Account account = repository.findByEmail(subject);
//		validate
		if (jwtUtil.validateToken(token, account)) {
			account.setPassword(null);
			return new MyResponseModel(jwtUtil.generateToken(account));
		}
		throw new UserNotFoundException("Invalid token");
	}
}
