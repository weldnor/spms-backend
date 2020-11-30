package com.weldnor.spms.repository;

import com.weldnor.spms.entity.UserGlobalRole;
import com.weldnor.spms.entity.pk.UserGlobalRolePK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGlobalRoleRepository extends CrudRepository<UserGlobalRole, UserGlobalRolePK> {
    List<UserGlobalRole> findAll();
}
