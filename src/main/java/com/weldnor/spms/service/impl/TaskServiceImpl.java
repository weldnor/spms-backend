package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.Task;
import com.weldnor.spms.repository.TaskRepository;
import com.weldnor.spms.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
