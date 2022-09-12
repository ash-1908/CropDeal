package com.demo.cropdeal.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
	private final JavaMailSender javaMailSender;
	
	private final String FROM = "noreply-cropdealproject@gmail.com";
	
	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void welcomeMail(String to, String name) {
		final String subject = "Welcome to CropDeal family";
		final String text = String.format("Dear %s, your account has been successfully created.", name);
		
		sendMail(to, name, subject, text);
	}
	
	public void resetPasswordMail(String to, String name, String link) {
		final String subject = "Reset CropDeal account password";
		final String text = "Click on this link or copy-paste it in the address bar to reset your password. Link: " + link;
		
		sendMail(to, name, subject, text);
	}
	
	private void sendMail(String to, String name, String subject, String text) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(FROM);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		
		javaMailSender.send(simpleMailMessage);
		System.out.println("Mail Send");
	}
}
