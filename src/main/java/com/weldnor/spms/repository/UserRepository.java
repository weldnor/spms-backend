package com.weldnor.spms.repository;

import com.weldnor.spms.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserId(long id);

    List<User> findAll();
}
