package com.weldnor.spms.dto.task;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UpdateTaskDto {
    @Size(min = 1, max = 40)
    @Pattern(regexp = "^[\\w ]*$")
    private String name;

    @Size(min = 1, max = 40)
    @Pattern(regexp = "^[\\w ]*$")
    private String description;


    private Long statusId;
}
