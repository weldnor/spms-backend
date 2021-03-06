package com.weldnor.spms.controller;

import com.weldnor.spms.dto.project.NewProjectDto;
import com.weldnor.spms.dto.project.ProjectDto;
import com.weldnor.spms.dto.project.UpdateProjectDto;
import com.weldnor.spms.entity.Project;
import com.weldnor.spms.mapper.project.ProjectMapper;
import com.weldnor.spms.service.ProjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(
        path = "api/projects",
        produces = "application/json"
)
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @GetMapping(path = "")
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectService.getAll();
        return projectMapper.toDto(projects);
    }

    @GetMapping(path = "/{id}")
    public ProjectDto getProject(@PathVariable("id") long id) {
        Project project = projectService.getById(id).orElseThrow();
        return projectMapper.toDto(project);
    }

    @PutMapping(path = "")
    public ProjectDto addProject(@RequestBody @Valid NewProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        project = projectService.add(project);
        return projectMapper.toDto(project);
    }

    @PostMapping(path = "/{id}")
    public void updateProject(@PathVariable(name = "id") long id, @RequestBody @Valid UpdateProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        projectService.update(project, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProject(@PathVariable("id") long id) {
        projectService.deleteById(id);
    }
}
