package com.Scopeindiawebsite.Scopeindiawebsite.controller;
import com.Scopeindiawebsite.Scopeindiawebsite.model.PickedCourse;
import com.Scopeindiawebsite.Scopeindiawebsite.service.PickedCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PickedCourseController {

    @Autowired
    private PickedCourseService pickedCourseService;

    @GetMapping("/pickedcourse")
    public String getPickedCourses(Model model) {
        List<PickedCourse> pickedCourses = pickedCourseService.getAllPickedCourses();
        model.addAttribute("courses", pickedCourses); // Ensure attribute name matches with Thymeleaf
        return "Pickedcourse"; // Ensure template name matches with Thymeleaf template file
    }

    @PostMapping("/removePickedCourse")
    public String removePickedCourse(@RequestParam Long id) {
        pickedCourseService.removePickedCourse(id);
        return "redirect:/pickedcourse";
    }
}
