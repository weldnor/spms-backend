package com.weldnor.spms.repository;

import com.weldnor.spms.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();

    Optional<Task> findByTaskId(long id);

    void deleteByTaskId(long id);
}
