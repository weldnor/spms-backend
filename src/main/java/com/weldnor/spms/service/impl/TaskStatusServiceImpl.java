package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.TaskStatus;
import com.weldnor.spms.repository.TaskStatusRepository;
import com.weldnor.spms.service.TaskStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {

    private final TaskStatusRepository taskStatusRepository;

    public TaskStatusServiceImpl(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    @Override
    public List<TaskStatus> getAll() {
        return taskStatusRepository.findAll();
    }
}
