
package com.Scopeindiawebsite.Scopeindiawebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Scopeindiawebsite.Scopeindiawebsite.model.signup;

public interface SignupRepository extends JpaRepository<signup, Long> {
    boolean existsByUsername(String username);
}
