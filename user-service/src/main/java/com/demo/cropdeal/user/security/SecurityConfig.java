package com.demo.cropdeal.user.security;

import java.lang.reflect.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.jsonwebtoken.lang.Arrays;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
//	private final JwtFilter myJwtFilter;
//	
//	@Autowired
//	public SecurityConfig(JwtFilter myJwtFilter) {
//		this.myJwtFilter = myJwtFilter;
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().anyRequest().permitAll().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.addFilterBefore(myJwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOriginsArraysasList("https://localhost:"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter(){
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods( "GET", "PUT", "POST", "DELETE");
			}
		};
	}
	
	
	
	
	
	
	
	
}


