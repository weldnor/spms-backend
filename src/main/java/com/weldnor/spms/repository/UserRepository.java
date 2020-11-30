package com.weldnor.spms.repository;

import com.weldnor.spms.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByUserId(long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> deleteByUserId(Long aLong);
}
