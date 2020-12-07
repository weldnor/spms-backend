package com.weldnor.spms.repository;

import com.weldnor.spms.entity.TaskStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskStatusRepository extends CrudRepository<TaskStatus, Long> {
    List<TaskStatus> findAll();
}
