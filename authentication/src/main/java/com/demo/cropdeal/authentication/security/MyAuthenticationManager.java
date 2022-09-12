package com.demo.cropdeal.authentication.security;

import com.demo.cropdeal.authentication.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationManager implements AuthenticationManager {
	private final AccountServiceImpl accountServiceImpl;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MyAuthenticationManager(AccountServiceImpl accountServiceImpl, BCryptPasswordEncoder passwordEncoder) {
		this.accountServiceImpl = accountServiceImpl;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//  check whether credentials are correct
		UserDetails userDetails = accountServiceImpl.loadUserByUsername(authentication.getName());
		
		if (passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(),
				userDetails.getAuthorities());
		}
		
		throw new BadCredentialsException("Invalid credentials");
	}
}
