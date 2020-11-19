package com.weldnor.spms.repository;

import com.weldnor.spms.entity.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByUserRoleId(long id);

    List<UserRole> findAll();
}
