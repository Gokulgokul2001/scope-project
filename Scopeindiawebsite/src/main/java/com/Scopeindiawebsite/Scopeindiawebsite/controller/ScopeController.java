package com.Scopeindiawebsite.Scopeindiawebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller

public class ScopeController {
	@Autowired
	private JavaMailSender emailSender;
	@GetMapping("/Home")
public String home() {
	return "/Home";
}
@GetMapping("/Contactus")
public String contactus() {
	return "/Contactus";
}

@PostMapping("/contactForm")
public String submitForm(
        @RequestParam String name,
        @RequestParam String phone,
        @RequestParam String email,
        @RequestParam String course,
        @RequestParam String address
) throws MessagingException {
    sendEmail(name, phone, email,course,address);
    return "/thanx";
}

private void sendEmail(String name, String phone,String email,String course,String address) throws MessagingException {
    MimeMessage mimeMessage = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo("gokulsubramonian2001@gmail.com");
        helper.setSubject("Form Submission");
        boolean html=true;
        helper.setText("<b>We will contact you Soon!!</b><br>"
        	    + "<b>Name:</b> " + name + "<br>"
        	    + "<b>Phone:</b> " + phone + "<br>"
        	    + "<b>Email:</b> " + email + "<br>"
        	    + "<b>Course:</b> " + course + "<br>"
        	    + "<b>Address:</b> " + address, html);

        emailSender.send(mimeMessage);
}
@GetMapping("/Knowscope")
public String know() {
	return "/Knowscope";
}



}

