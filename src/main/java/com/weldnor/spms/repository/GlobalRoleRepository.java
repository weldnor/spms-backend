package com.weldnor.spms.repository;

import com.weldnor.spms.entity.GlobalRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GlobalRoleRepository extends CrudRepository<GlobalRole, Long> {
    GlobalRole findByGlobalRoleId(long id);

    List<GlobalRole> findAll();
}
