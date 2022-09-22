package com.demo.cropdeal.authentication.service;

import com.demo.cropdeal.authentication.dao.IAccountRepository;
import com.demo.cropdeal.authentication.exception.*;
import com.demo.cropdeal.authentication.exception.handler.PhoneNumberNotFoundException;
import com.demo.cropdeal.authentication.model.Account;
import com.demo.cropdeal.authentication.model.MyRequestModel;
import com.demo.cropdeal.authentication.model.MyResponseModel;
import com.demo.cropdeal.authentication.security.util.JwtUtil;
import net.bytebuddy.utility.RandomString;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
		Optional<Account> user = repository.findByEmail(email);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found with given email: " + email);
		}
		return user.get();
	}
	
	@Override
	public MyResponseModel signUpWithEmail(MyRequestModel req) {
		if (!req.signUpValidation()) {
			throw new InvalidCredentialsException("Field(s) cannot be empty.");
		}
		
		// check if account object already exist in database
		Optional<Account> dataFromDb = repository.findByEmail(req.getEmail());
		if (dataFromDb.isEmpty()) {
			// if account object doesn't already exist in database
			// save the account object into database
			String encryptedPwd = passwordEncoder.encode(req.getPassword());
			req.setPassword(encryptedPwd);
			Account account = new Account(req);
			repository.save(account);
			account.setPassword(null);
			String JWT_TOKEN = jwtUtil.generateToken(account);
			return new MyResponseModel(JWT_TOKEN, account.getId(), account.getFullName(), account.getRoles());
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
		Optional<Account> accountData = repository.findByEmail(req.getEmail());
		if (accountData.isPresent()) {
			Account account = accountData.get();
			// check if password is correct
			if (passwordEncoder.matches(req.getPassword(), account.getPassword())) {
				account.setPassword(null);
				String JWT_TOKEN = jwtUtil.generateToken(account);
				return new MyResponseModel(JWT_TOKEN, account.getId(), account.getFullName(), account.getRoles());
			}
			// throw exception if password is wrong
			throw new InvalidPasswordException("Invalid password.");
		}
		// throw exception if account object is not in database
		throw new UserNotFoundException("User does not exist.");
	}
	
	
	public Boolean validateOTP(MyRequestModel req) {
		String otp = req.getResetCode();
		String id = req.getId();
		if (id == null || id.isBlank())
			throw new RuntimeException("User id cannot be null");
		if (otp == null && otp.isBlank())
			throw new RuntimeException("OTP cannot be null");
		
		Account accountData = repository.findById(new ObjectId(id)).get();
		return accountData.getResetCode().equals(otp);
	}
	
	@Override
	public MyResponseModel resetPassword(MyRequestModel req, String resetToken) {
		if (!req.resetPasswordValidation()) {
			throw new InvalidCredentialsException("Password/Reset-token field(s) cannot be empty.");
		}
		
		String password = req.getPassword();
		
		Optional<Account> accountData = repository.findByResetCode(resetToken);
		
		if (accountData.isPresent() && accountData.get().getResetCode().equals(resetToken)) {
			Account account = accountData.get();
			String encryptedPassword = passwordEncoder.encode(password);
			account.setPassword(encryptedPassword);
			account.setResetCode(null);
			repository.save(account);
			account.setPassword(null);
			String JWT_TOKEN = jwtUtil.generateToken(account);
			return new MyResponseModel(JWT_TOKEN);
		}
		
		throw new InvalidSessionException("Invalid session. Please try " + "again later.");
	}
	
	@Override
	public MyResponseModel forgotPassword(String url, String email, String method) {
		MyResponseModel response = new MyResponseModel();
		if (email == null || email.isBlank()) throw new InvalidCredentialsException("Email field cannot be empty.");
		
		Optional<Account> accountData = repository.findByEmail(email);
		
		if (accountData.isEmpty()) throw new UserNotFoundException("User with email: " + email + " not found.");
		
		Account account = accountData.get();
//		if method value is otp, only then we will send sms, else we will send email
		if (method.equalsIgnoreCase("otp")) {
			
			if (account.getPhoneNumber() == null) throw new PhoneNumberNotFoundException("Phone number not found.");
			
			Integer otp = (int)
				(Math.floor(Math.random() * 10000 + Math.random() * 1000 + Math.random() * 100 + Math.random() * 10));
			
			account.setResetCode(otp.toString());
			repository.save(account);
			
			smsService.sendOTP(account.getPhoneNumber(), otp.toString());
			
			response.setId(account.getId());
			response.setPhone(account.getPhoneNumber());
			return response;
		} else {
			final String resetCode = RandomString.make(20);
			
			account.setResetCode(resetCode);
			repository.save(account);
			
			final String link = url + "/reset?token=" + resetCode;
			
			emailService.resetPasswordMail(account.getUsername(), account.getFullName(), link);
			
			response.setEmail(account.getEmail());
			return response;
		}
	}
	
	@Override
	//	helper method for api gateway to validate token
	public MyResponseModel validateToken(String token) {
		if (token == null || token.isBlank()) throw new InvalidSessionException("Unauthenticated.");
//		get the subject from token
		String subject = jwtUtil.getUsernameFromToken(token);
		if (subject == null) throw new InvalidSessionException("Invalid session.");
//		fetch the data from backend
		Optional<Account> accountData = repository.findByEmail(subject);
		if (accountData.isPresent()) {
			Account account = accountData.get();
//		validate
			if (jwtUtil.validateToken(token, account)) {
				MyResponseModel res = new MyResponseModel(account.getId(), account.getFullName(), account.getRoles());
				return res;
			} else {
				throw new InvalidSessionException("Data out of sync.");
			}
		} else {
			throw new InvalidSessionException("Invalid session");
		}
	}
}
