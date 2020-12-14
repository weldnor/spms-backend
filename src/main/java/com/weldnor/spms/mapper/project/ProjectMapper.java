package com.weldnor.spms.mapper.project;

import com.weldnor.spms.dto.project.NewProjectDto;
import com.weldnor.spms.dto.project.ProjectDto;
import com.weldnor.spms.entity.Project;
import com.weldnor.spms.entity.User;
import com.weldnor.spms.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public ProjectMapper(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void configMapper() {
    }

    public Project toEntity(NewProjectDto dto) {
        Project project = mapper.map(dto, Project.class);
        System.out.println(dto);
        User owner = userRepository.findByUserId(dto.getOwnerId()).orElseThrow();
        project.setOwner(owner);
        return project;
    }

    public ProjectDto toDto(Project entity) {
        ProjectDto projectDto = mapper.map(entity, ProjectDto.class);
        projectDto.setOwnerId(entity.getOwner().getUserId());
        return projectDto;
    }

    public List<ProjectDto> toDto(List<Project> entityList) {
        List<ProjectDto> dtoList = new ArrayList<>();

        for (Project entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
