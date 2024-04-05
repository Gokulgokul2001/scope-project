package com.Scopeindiawebsite.Scopeindiawebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Scopeindiawebsite.Scopeindiawebsite.model.login;
import com.Scopeindiawebsite.Scopeindiawebsite.service.LoginService;

@Controller
public class ForgotPasswordController {
	  @Autowired
	    private LoginService loginService;

	  @GetMapping("/forgotpassword")
	    public String showForgotPasswordForm(Model model) {
	        model.addAttribute("login", new login());
	        return "forgotpassword";
	    }
	    @PostMapping("/forgotpassword")
	    public String sendTemporaryPassword(@ModelAttribute("login") login login) {
	        login existingUser = loginService.findByEmail(login.getEmail());
	        if (existingUser != null) {
	            loginService.generateAndSendTemporaryPassword(existingUser.getEmail());
	            return "redirect:/Login?tempPasswordSent=true";
	        } else {
	            return "redirect:/forgotpassword?error=true";
	        }
	    }

}
