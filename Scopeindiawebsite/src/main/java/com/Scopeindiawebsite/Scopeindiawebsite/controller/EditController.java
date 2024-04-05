package com.Scopeindiawebsite.Scopeindiawebsite.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Scopeindiawebsite.Scopeindiawebsite.model.Registrationform;
import com.Scopeindiawebsite.Scopeindiawebsite.service.RegistrationService;

@Controller
public class EditController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/Edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Registrationform registrationForm = registrationService.findById(id);
        model.addAttribute("registrationForm", registrationForm);
        return "Edit"; 
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("registrationForm") Registrationform registrationForm,
                                @RequestParam("fileToUpload") MultipartFile file,
                                RedirectAttributes redirectAttributes) {
        try {
            if (!file.isEmpty()) {
                registrationForm.setPhoto(file.getBytes());
            }
            registrationService.save(registrationForm);
            redirectAttributes.addFlashAttribute("successMessage", "Profile updated successfully");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update profile: Please try again later");
        }
        return "redirect:/thanx"; 
    }
}
