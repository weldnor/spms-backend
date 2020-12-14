package com.weldnor.spms.dto.project;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateProjectDto {
    @Size(min = 1, max = 40)
    private String name;

    private long ownerId;

    private String description;
}
