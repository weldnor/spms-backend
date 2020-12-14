package com.weldnor.spms.dto.project;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewProjectDto {
    @Size(min = 1, max = 40)
    @NotNull
    private String name;

    @NotNull
    private long ownerId;

    private String description;
}
