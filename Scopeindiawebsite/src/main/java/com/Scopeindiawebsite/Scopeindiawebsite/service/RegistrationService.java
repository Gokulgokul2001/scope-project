package com.Scopeindiawebsite.Scopeindiawebsite.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Scopeindiawebsite.Scopeindiawebsite.model.Registrationform;
import com.Scopeindiawebsite.Scopeindiawebsite.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registrationform findById(Integer id) {
        return registrationRepository.findById(id).orElse(null);
    }

    public Registrationform save(Registrationform registrationForm) {
        return registrationRepository.save(registrationForm);
    }
    public Registrationform findByEmail(String email) {
        return registrationRepository.findByEmail(email);
    }
}
