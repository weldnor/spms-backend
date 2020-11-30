package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.User;
import com.weldnor.spms.repository.UserRepository;
import com.weldnor.spms.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> deleteById(Long id) {
        Optional<User> user = getById(id);
        userRepository.deleteById(id);
        return user;
    }
}
