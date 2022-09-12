package com.demo.cropdeal.authentication;

import com.demo.cropdeal.authentication.dao.IAccountRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = IAccountRepository.class)
@OpenAPIDefinition(info = @Info(title = "Authentication API", version = "1.0.0",
	description = "This API is responsible for user authentication and signup.",
	contact = @Contact(name = "Anmol Sharma", email = "cropdealproject@gmail.com")),
	tags = {@Tag(name = "Sign in", description = "This route is for user sign in."),
		@Tag(name = "Sign up", description = "This route is for user sign up."),
		@Tag(name = "Test route", description = "This route is for testing purpose and will be removed in production")})
public class AuthenticationApplication {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(AuthenticationApplication.class, args);
		
		
	}
	
	
}
