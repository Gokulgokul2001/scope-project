package com.Scopeindiawebsite.Scopeindiawebsite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Scopeindiawebsite.Scopeindiawebsite.model.Course;
import com.Scopeindiawebsite.Scopeindiawebsite.service.CourseService;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/Searchcourse")
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "Searchcourse";
    }
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/list";
    }
    @PostMapping("/api/pickCourse")
    public String pickCourse(@RequestParam String id, @RequestParam String name, @RequestParam String duration, @RequestParam String fee) {
        return "Pickedcourse";
    }
}
