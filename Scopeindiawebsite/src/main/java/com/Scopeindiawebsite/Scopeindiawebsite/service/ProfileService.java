package com.Scopeindiawebsite.Scopeindiawebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Scopeindiawebsite.Scopeindiawebsite.model.Registrationform;
import com.Scopeindiawebsite.Scopeindiawebsite.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    public Registrationform getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }
}
