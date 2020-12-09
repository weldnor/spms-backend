package com.weldnor.spms.repository;

import com.weldnor.spms.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
}
