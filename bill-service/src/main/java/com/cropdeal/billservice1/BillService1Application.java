package com.cropdeal.billservice1;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.event.EventListener;



import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

@EnableEurekaClient
@EnableSwagger2
public class BillService1Application {

	public static void main(String[] args) {
		SpringApplication.run(BillService1Application.class, args);
	}
	@Autowired
	private EmailSenderService senderService;
	
	

	
	public void triggerMail() throws MessagingException{
	
		senderService.sendSimpleEmail("muratdeniz0005@gmail.com", "Thanks for purchasing item...!", "Cropdeal-Bill");

		
	}

}
