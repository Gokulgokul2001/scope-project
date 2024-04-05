package com.Scopeindiawebsite.Scopeindiawebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Scopeindiawebsite.Scopeindiawebsite.model.login;
import com.Scopeindiawebsite.Scopeindiawebsite.service.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/Login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new login());
        return "Login"; 
    }
    @GetMapping("/Dashboard")
    public String dashboard() {
    	return "Dashboard";
    }

    @PostMapping("/Login")
    public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model, 
                        @RequestParam String email, @RequestParam String password, 
                        @RequestParam(required = false) String keepLoggedIn) {
        login existingUser = loginService.findByEmail(email);
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", existingUser);
            if (keepLoggedIn != null) {
                Cookie cookie = new Cookie("loggedInUser", existingUser.getEmail());
                cookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(cookie);
            }
            return "redirect:/Dashboard"; 
        } else {
            model.addAttribute("error", true);
            return "Login";
        }
    }
    
    @GetMapping("/Changepassword")
    public String showChangePasswordForm() {
        return "Changepassword"; 
    }

    @PostMapping("/Changepassword")
    public String changePassword(HttpSession session, Model model, 
                                 @RequestParam String currentPassword, 
                                 @RequestParam String newPassword, 
                                 @RequestParam String confirmPassword) {
        login loggedInUser = (login) session.getAttribute("loggedInUser");
        if (loggedInUser != null && loggedInUser.getPassword().equals(currentPassword) && newPassword.equals(confirmPassword)) {
            loggedInUser.setPassword(newPassword);
            loggedInUser.setTemporaryPassword(false);
            loginService.save(loggedInUser);
            return "/Login";
        } else {
            model.addAttribute("error", true);
            return "Changepassword";
        }
    }
    @GetMapping("/Pickedcourse")
    public String Pick() {
    	return "Pickedcourse";
    }
    
}
