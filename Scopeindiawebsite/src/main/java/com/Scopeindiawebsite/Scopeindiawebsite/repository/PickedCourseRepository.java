package com.Scopeindiawebsite.Scopeindiawebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Scopeindiawebsite.Scopeindiawebsite.model.PickedCourse;

@Repository
public interface PickedCourseRepository extends JpaRepository<PickedCourse, Long> {
    
}
