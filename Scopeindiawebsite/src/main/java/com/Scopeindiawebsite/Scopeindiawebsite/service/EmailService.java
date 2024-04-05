package com.Scopeindiawebsite.Scopeindiawebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTemporaryPassword(String to, String tempPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Temporary Password");
        message.setText("Your temporary password is: " + tempPassword);
        javaMailSender.send(message);
    }
}
