package com.Scopeindiawebsite.Scopeindiawebsite.service;

import com.Scopeindiawebsite.Scopeindiawebsite.model.PickedCourse;
import com.Scopeindiawebsite.Scopeindiawebsite.repository.PickedCourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickedCourseService {

    @Autowired
    private PickedCourseRepository pickedCourseRepository;

    public List<PickedCourse> getAllPickedCourses() {
        return pickedCourseRepository.findAll();
    }

    public void removePickedCourse(Long id) {
        pickedCourseRepository.deleteById(id);
    }

    public void addPickedCourse(PickedCourse pickedCourse) {
        pickedCourseRepository.save(pickedCourse);
    }
}
