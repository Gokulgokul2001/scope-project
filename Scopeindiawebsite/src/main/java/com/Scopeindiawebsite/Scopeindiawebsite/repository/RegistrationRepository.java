package com.Scopeindiawebsite.Scopeindiawebsite.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Scopeindiawebsite.Scopeindiawebsite.model.Registrationform;

@Repository
public interface RegistrationRepository extends JpaRepository<Registrationform, Integer> {
    Optional<Registrationform> findById(Long userId);

	Registrationform findByEmail(String email);
}

