package com.weldnor.spms.dto.project;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UpdateProjectDto {
    @Size(min = 1, max = 40)
    @Pattern(regexp = "^[\\w ]*$")
    private String name;

    private long ownerId;

    @Pattern(regexp = "^[\\w ]*$")
    private String description;
}
