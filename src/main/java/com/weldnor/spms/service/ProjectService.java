package com.weldnor.spms.service;

import com.weldnor.spms.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAll();

    Optional<Project> getById(long id);

    void deleteById(long id);
}
