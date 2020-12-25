package com.weldnor.spms.service;

import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.entity.Project;

import java.util.List;
import java.util.Optional;

public interface GlobalRoleService {
    List<GlobalRole> getAll();

    Optional<GlobalRole> getById(long id);

    Optional<GlobalRole> getByName(String name);

    GlobalRole add(GlobalRole globalRole);

    void update(GlobalRole globalRole, long id);

    void deleteById(long id);
}
