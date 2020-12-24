package com.weldnor.spms.dto.task;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class NewTaskDto {
    @NotNull
    private Long projectId;
    @NotNull
    private Long creatorId;

    @Size(min = 1, max = 40)
    @Pattern(regexp = "^[\\w ]*$")
    @NotNull
    private String name;

    @Size(min = 1, max = 40)
    @Pattern(regexp = "^[\\w ]*$")
    private String description;

    @NotNull
    private Long statusId;
}
