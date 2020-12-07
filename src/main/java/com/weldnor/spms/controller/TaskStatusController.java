package com.weldnor.spms.controller;

import com.weldnor.spms.entity.TaskStatus;
import com.weldnor.spms.service.TaskStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/task_statuses",
        produces = "application/json"
)
public class TaskStatusController {

    private final TaskStatusService taskStatusService;

    public TaskStatusController(TaskStatusService taskStatusService) {
        this.taskStatusService = taskStatusService;
    }

    @GetMapping(path = "")
    public List<TaskStatus> getAllGlobalRoles() {
        return taskStatusService.getAll();
    }
}
