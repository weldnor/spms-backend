package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.Task;
import com.weldnor.spms.mapper.task.TaskMapper;
import com.weldnor.spms.repository.TaskRepository;
import com.weldnor.spms.service.TaskService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getById(long id) {
        return taskRepository.findByTaskId(id);
    }

    @Override
    public Task add(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void update(Task task, long id) {
        Task original = getById(id).orElseThrow();
        taskMapper.merge(original, task);
        taskRepository.save(original);
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteByTaskId(id);
    }
}
