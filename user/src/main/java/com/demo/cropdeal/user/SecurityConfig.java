package com.demo.cropdeal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.cropdeal.user.service.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/user-microservice/user/**").hasRole("DEALER")
		.antMatchers(HttpMethod.DELETE,"/user-microservice/user/**").permitAll()
		.antMatchers(HttpMethod.GET,"/user-microservice/user/**").hasRole("DEALER")
		.antMatchers(HttpMethod.PUT,"/user-microservice/user/**").permitAll()
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	
	@Bean
	public PasswordEncoder getPassEncoder()
	{
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		return encoder;
	}
	

/*
	@Autowired
	private JwtRequestFilter jwtFilter;

	//  creating our custom authorizations using spring security authorization
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
		 .antMatchers("/user-microservice/user/**").hasAnyAuthority("DEALER")
		 .and().sessionManagement()
		 .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
	
	*/
	
	/*
	@Autowired
	MyUserDetailsService myUserDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		 
		 auth.authenticationProvider(getAuthProvider());
		 
	}
	
	private AuthenticationProvider getAuthProvider() {
		 DaoAuthenticationProvider auth =new DaoAuthenticationProvider();
		 auth.setUserDetailsService(myUserDetailsService);
		 auth.setPasswordEncoder(getPassEncoder());
		 System.out.println("auth  "+auth);
		 return auth;
	}
	

	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/user/**").permitAll()
		.antMatchers(HttpMethod.DELETE,"/user/delete-user/{userId}").hasAnyAuthority("farmer")
		.antMatchers(HttpMethod.GET,"/user-microservice/user/get-user/{userId}").hasAnyAuthority("DEALER")
		.antMatchers(HttpMethod.PUT,"/user/update-user/{userId}").authenticated()

		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable(); ///
	}
	
	*/
	

}


