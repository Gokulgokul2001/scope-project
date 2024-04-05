package com.Scopeindiawebsite.Scopeindiawebsite.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.Scopeindiawebsite.Scopeindiawebsite.model.Registrationform;
import com.Scopeindiawebsite.Scopeindiawebsite.repository.RegistrationRepository;

@Controller
public class RegistrationController {

	 @Autowired
	    private RegistrationRepository re;

	    @Autowired
	    private JavaMailSender emailSender;

	    @Value("${upload.folder}")
	    private String uploadFolder;

	    @GetMapping("/Registernow")
	    public String register() {
	        return "Registernow"; 
	    }

	    @PostMapping("/registerform")
	    public String registerForm(Registrationform registrationform, @RequestParam("fileToUpload") MultipartFile file) {
	        try {
	            registrationform.setPhoto(file.getBytes());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        re.save(registrationform);
	        sendEmail(registrationform);
	        return "thanx"; 
	    }

	    private void sendEmail(Registrationform registrationform) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(registrationform.getEmail());
	        message.setSubject("Registration Successful");
	        message.setText("Dear " + registrationform.getFirstname() + ",\n\n"
	                + "Thank you for registering. Your registration has been successful.\n\n"
	                + "Regards,\nScope India Team");
	        emailSender.send(message);
	    }
	    @GetMapping("/thanx")
	    public String thank() {
	    	return"/thanx";
	    }
}
