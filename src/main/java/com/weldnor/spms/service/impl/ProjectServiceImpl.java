package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.Project;
import com.weldnor.spms.mapper.project.ProjectMapper;
import com.weldnor.spms.repository.ProjectRepository;
import com.weldnor.spms.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getById(long id) {
        return projectRepository.findByProjectId(id);
    }

    @Override
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void update(Project project, long id) {
        Project original = getById(id).orElseThrow();
        projectMapper.merge(original, project);
        projectRepository.save(original);
    }

    @Override
    public void deleteById(long id) {
        projectRepository.deleteByProjectId(id);
    }
}
