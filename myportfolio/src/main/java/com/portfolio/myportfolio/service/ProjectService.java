package com.portfolio.myportfolio.service;

import com.portfolio.myportfolio.model.Project;
import com.portfolio.myportfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    // Get all projects
    public List<Project> getAll() {
        return repo.findAll();
    }

    // Save or update project
    public void save(Project p) {
        repo.save(p);
    }

    // Delete project by ID
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Get project by ID (ADDED)
    public Optional<Project> getById(Long id) {
        return repo.findById(id);
    }
}
