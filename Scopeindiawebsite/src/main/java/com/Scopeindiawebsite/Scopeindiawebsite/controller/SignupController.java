package com.Scopeindiawebsite.Scopeindiawebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Scopeindiawebsite.Scopeindiawebsite.model.login;
import com.Scopeindiawebsite.Scopeindiawebsite.model.signup;
import com.Scopeindiawebsite.Scopeindiawebsite.service.LoginService;
import com.Scopeindiawebsite.Scopeindiawebsite.service.SignupService;

@Controller
public class SignupController {
    @Autowired
    private SignupService signupService;
    
    @Autowired
    private LoginService loginService;

    @RequestMapping("/signup")
    public String signupForm() {
        return "signup"; 
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signUp(@ModelAttribute signup signup) {
        if (signup == null || signup.getUsername() == null || signup.getPassword() == null) {
            return "Invalid user data";
        }
        if (signupService.isUserExists(signup.getUsername())) {
            return "User already exists";
        }
        signupService.saveUser(signup);
        login loginEntry = new login();
        loginEntry.setEmail(signup.getEmail());
        loginEntry.setPassword(signup.getPassword());
        loginService.save(loginEntry);

        return "Signup successful";
    }
}
