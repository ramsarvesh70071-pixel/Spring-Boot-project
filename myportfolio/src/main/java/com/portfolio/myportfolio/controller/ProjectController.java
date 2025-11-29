package com.portfolio.myportfolio.controller;

import com.portfolio.myportfolio.model.Project;
import com.portfolio.myportfolio.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    // Load Admin Page with Project List
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("projects", service.getAll());
        return "admin";
    }

    // Add New Project (POST)
    @PostMapping("/admin/add")
    public String add(@ModelAttribute Project project) {
        service.save(project);
        return "redirect:/admin";
    }

    // Delete Project by ID
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin";
    }
}
