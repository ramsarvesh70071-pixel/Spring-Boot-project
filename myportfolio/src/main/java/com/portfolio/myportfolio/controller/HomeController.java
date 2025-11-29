package com.portfolio.myportfolio.controller;

import com.portfolio.myportfolio.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProjectService projectService;

    public HomeController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("projects", projectService.getAll());
        return "index";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", projectService.getAll());
        return "projects";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
