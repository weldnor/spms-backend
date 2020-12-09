package com.weldnor.spms.controller;

import com.weldnor.spms.entity.Project;
import com.weldnor.spms.entity.Task;
import com.weldnor.spms.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/tasks",
        produces = "application/json"
)
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "")
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }
}
