package com.Scopeindiawebsite.Scopeindiawebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Scopeindiawebsite.Scopeindiawebsite.model.login;
@Repository
public interface LoginRepository extends JpaRepository<login, Long> {
	login findByEmail(String email);
	}



    
