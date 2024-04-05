package com.Scopeindiawebsite.Scopeindiawebsite.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Scopeindiawebsite.Scopeindiawebsite.model.login;
import com.Scopeindiawebsite.Scopeindiawebsite.repository.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private EmailService emailService;

    public login findByEmail(String email) {
        return loginRepository.findByEmail(email);
    }

    public boolean authenticateUser(String email, String password) {
        login user = findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public void generateAndSendTemporaryPassword(String email) {
        login user = findByEmail(email);
        if (user != null) {
            String tempPassword = generateTemporaryPassword();
            user.setPassword(tempPassword);
            user.setTemporaryPassword(true);
            loginRepository.save(user);
            emailService.sendTemporaryPassword(email, tempPassword);
        }
    }

    public void resetPassword(String email) {
        login user = findByEmail(email);
        if (user != null) {
            String tempPassword = generateTemporaryPassword();
            user.setPassword(tempPassword);
            user.setTemporaryPassword(true);
            loginRepository.save(user);
            emailService.sendTemporaryPassword(email, tempPassword);
        }
    }

    public void save(login user) {
        loginRepository.save(user);
    }

    private String generateTemporaryPassword() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int PASSWORD_LENGTH = 8;
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }
}
