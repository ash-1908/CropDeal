package com.demo.cropdeal.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService  {
	
	@Autowired
	private JavaMailSender javaMailSender; 
	
	public void sendEmail(String toEmail,String body,String subject) {
		
		var msg=new SimpleMailMessage();
		msg.setFrom("rutujabhoite2050@gmail.com");
		msg.setTo(toEmail);
		msg.setText(body);
		msg.setSubject(subject);
		
	    javaMailSender.send(msg);
	    
	 
	}
		

}
