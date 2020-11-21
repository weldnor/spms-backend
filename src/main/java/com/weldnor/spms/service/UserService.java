package com.weldnor.spms.service;

import com.weldnor.spms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    void delete(Long id);
}