package com.weldnor.spms.dto.task;

import lombok.Data;

@Data
public class TaskDto {
    private Long taskId;
    private Long projectId;
    private Long creatorId;
    private String name;
    private String description;
    private Long statusId;
}
