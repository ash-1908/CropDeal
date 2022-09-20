package com.demo.cropdeal.authentication.security;

import com.demo.cropdeal.authentication.security.filters.MyJwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
	private final MyJwtFilter myJwtFilter;
	
	@Autowired
	public SecurityConfiguration(MyJwtFilter myJwtFilter) {
		this.myJwtFilter = myJwtFilter;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests()
			.anyRequest()
			.permitAll()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors().disable();
		http.addFilterBefore(myJwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	
}
