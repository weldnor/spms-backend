package com.weldnor.spms.dto.project;

import lombok.Data;

@Data
public class ProjectDto {
    private long projectId;
    private String name;
    private long ownerId;
    private String description;
}
