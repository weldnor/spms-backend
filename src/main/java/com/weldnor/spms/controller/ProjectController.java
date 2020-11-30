package com.weldnor.spms.controller;

import com.weldnor.spms.entity.Project;
import com.weldnor.spms.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/projects",
        produces = "application/json"
)
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "")
    public List<Project> getAllProjects() {
        return projectService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Project getProject(@PathVariable("id") long id) {
        return projectService.getById(id).orElseThrow();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProject(@PathVariable("id") long id) {
        projectService.deleteById(id);
    }
}
