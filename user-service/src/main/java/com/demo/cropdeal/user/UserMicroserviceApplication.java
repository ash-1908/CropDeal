package com.demo.cropdeal.user;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/user/**"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.cropdeal"))
				.build()
				.apiInfo(apiDetails());
		
	}

	 
	 
	private ApiInfo apiDetails(){
		
		return new ApiInfo(
				
				"User Profile Api",
				"API for CROP-DEAL SYSTEM project",
				"1.0",
				"free to use",
				new springfox.documentation.service.Contact("Rutuja Bhoite","http//microservice.cg","rsb@gmail.com"),
				"API license",
				"http://microservice.io",
				Collections.emptyList());
        }	
		
	
	
	
	
}
