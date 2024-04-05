package com.Scopeindiawebsite.Scopeindiawebsite.service;

import com.Scopeindiawebsite.Scopeindiawebsite.model.signup;

public interface SignupService {

    boolean isUserExists(String username);

    void saveUser(signup user);
}
