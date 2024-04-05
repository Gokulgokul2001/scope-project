package com.Scopeindiawebsite.Scopeindiawebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Scopeindiawebsite.Scopeindiawebsite.model.Registrationform;

@Repository
public interface ProfileRepository extends JpaRepository<Registrationform, Long> {

}
