package com.demo.cropdeal.authentication.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
	
	@Value("${twilio.phone}")
	private String from_phone;
	@Value("${twilio.auth}")
	private String auth_token;
	@Value("${twilio.sid}")
	private String account_sid;
	
	private void sendSms(String to_phone, String msg) {
		Twilio.init(account_sid, auth_token);
		PhoneNumber toPhone = new PhoneNumber(to_phone);
		PhoneNumber fromPhone = new PhoneNumber(from_phone);
		
		Message message = Message.creator(toPhone, fromPhone, msg).create();
		
		System.out.println(message.getSid());
	}
	
	public void sendOTP(String to_phone, String otp) {
		final String MSG = "This OTP is valid for 10 minutes only. Please use this one-time-password for resetting your " +
			"account password. OTP: " + otp;
		
		sendSms(to_phone, MSG);
	}
}
