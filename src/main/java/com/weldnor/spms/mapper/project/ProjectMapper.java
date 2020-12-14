package com.weldnor.spms.mapper.project;

import com.weldnor.spms.dto.project.ProjectDto;
import com.weldnor.spms.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {
    private final ModelMapper mapper;

    public ProjectMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    private void configMapper() {
    }

//    public Project toEntity(ProjectDto dto) {
//        return mapper.map(dto, Project.class);
//    }

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
