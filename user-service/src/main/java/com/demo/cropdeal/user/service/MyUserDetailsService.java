package com.demo.cropdeal.user.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.cropdeal.user.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		var user=userRepository.getByUserName(username);

	return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),Arrays.asList(new SimpleGrantedAuthority("ROLE_DEALER"))); 
	
		
       
	}



}