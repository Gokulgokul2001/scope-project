package com.Scopeindiawebsite.Scopeindiawebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ForgetService {
	   @Autowired
	    private JavaMailSender emailSender;

	    public void sendEmail(String to, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("OTP Verification");
	        message.setText("Your OTP for verification is: " + otp);
	        emailSender.send(message);
	    }
}
