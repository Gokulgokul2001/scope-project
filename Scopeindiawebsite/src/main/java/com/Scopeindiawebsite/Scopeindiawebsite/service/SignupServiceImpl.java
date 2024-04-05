
package com.Scopeindiawebsite.Scopeindiawebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Scopeindiawebsite.Scopeindiawebsite.model.signup;
import com.Scopeindiawebsite.Scopeindiawebsite.repository.SignupRepository;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    private SignupRepository signupRepository;

    @Override
    public boolean isUserExists(String username) {
        return signupRepository.existsByUsername(username);
    }

    @Override
    public void saveUser(signup user) {
        signupRepository.save(user);
    }
}
