/*package com.portfolio.myportfolio.controller;

import com.portfolio.myportfolio.model.Project;
import com.portfolio.myportfolio.service.FileStorageService;
import com.portfolio.myportfolio.service.ProjectService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProjectService projectService;
    private final FileStorageService fileStorageService;

    public AdminController(ProjectService projectService, FileStorageService fileStorageService) {
        this.projectService = projectService;
        this.fileStorageService = fileStorageService;
    }

    // ------------------- ADMIN HOME -------------------
    @GetMapping
    public String adminPanel(Model model) {
        model.addAttribute("projects", projectService.getAll());
        model.addAttribute("project", new Project());
        return "admin";
    }

    // ------------------- ADD PROJECT -------------------
    @PostMapping("/add")
    public String addProject(@ModelAttribute Project project,
                             @RequestParam(name = "imageFile", required = false) MultipartFile imageFile)
            throws IOException {

        if (imageFile != null && !imageFile.isEmpty()) {
            String filename = "proj-img-" + System.currentTimeMillis() + "-" + imageFile.getOriginalFilename();
            fileStorageService.store(imageFile, filename);
            project.setImagePath("/uploads/" + filename);
        }

        projectService.save(project);
        return "redirect:/admin";
    }

    // ------------------- EDIT FORM -------------------
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Project> p = projectService.getById(id);

        if (p.isPresent()) {
            model.addAttribute("project", p.get());
            model.addAttribute("projects", projectService.getAll());
            return "admin";
        }
        return "redirect:/admin";
    }

    // ------------------- UPDATE PROJECT -------------------
    @PostMapping("/update")
    public String updateProject(@ModelAttribute Project project,
                                @RequestParam(name = "imageFile", required = false) MultipartFile imageFile)
            throws IOException {

        if (imageFile != null && !imageFile.isEmpty()) {
            String filename = "proj-img-" + System.currentTimeMillis() + "-" + imageFile.getOriginalFilename();
            fileStorageService.store(imageFile, filename);
            project.setImagePath("/uploads/" + filename);
        }

        projectService.save(project);
        return "redirect:/admin";
    }

    // ------------------- DELETE PROJECT -------------------
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        projectService.delete(id);
        return "redirect:/admin";
    }

    // ------------------- RESUME DOWNLOAD -------------------
    @GetMapping("/resume/download")
    public ResponseEntity<Resource> downloadResume() throws Exception {

        Resource resource = fileStorageService.loadAsResource("resume.pdf");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resume.pdf")
                .body(resource);
    }
}
*/