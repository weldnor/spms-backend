package com.weldnor.spms.service;

import com.weldnor.spms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    Optional<User> getByUsername(String username);

    Optional<User> getById(long id);

    Optional<User> getByEmail(String email);

    void deleteById(long id);
}