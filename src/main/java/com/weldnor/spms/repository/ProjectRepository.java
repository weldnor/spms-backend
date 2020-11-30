package com.weldnor.spms.repository;


import com.weldnor.spms.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findAll();

    Optional<Project> findByProjectId(long id);

    void deleteByProjectId(long id);
}
