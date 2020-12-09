package com.weldnor.spms.repository;

import com.weldnor.spms.entity.GlobalRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GlobalRoleRepository extends CrudRepository<GlobalRole, Long> {
    Optional<GlobalRole> findByGlobalRoleId(long id);

    Optional<GlobalRole> findByName(String name);

    List<GlobalRole> findAll();
}
