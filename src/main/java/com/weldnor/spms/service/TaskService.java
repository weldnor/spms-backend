package com.weldnor.spms.service;

import com.weldnor.spms.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAll();

    Optional<Task> getById(long id);

    Task add(Task task);

    void update(Task task, long id);

    void deleteById(long id);
}
