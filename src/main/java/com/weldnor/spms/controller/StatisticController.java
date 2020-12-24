package com.weldnor.spms.controller;

import com.weldnor.spms.repository.ProjectRepository;
import com.weldnor.spms.repository.TaskRepository;
import com.weldnor.spms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(
        path = "api/statistic",
        produces = "application/json"
)
public class StatisticController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping(path = "/users_count")
    public long getUsersCount() {
        return userRepository.count();
    }

    @GetMapping(path = "/users_admins_count")
    public long getAdminsCount() {
        return userRepository.getAdminsCount();
    }

    @GetMapping(path = "/projects_count")
    public long getProjectsCount() {
        return projectRepository.count();
    }
    @GetMapping(path = "/projects_active_count")
    public long getActiveProjectsCount() {
        return projectRepository.getActiveProjectsCount();
    }

    @GetMapping(path = "/tasks_count")
    public long getTasksCount() {
        return taskRepository.count();
    }
}
