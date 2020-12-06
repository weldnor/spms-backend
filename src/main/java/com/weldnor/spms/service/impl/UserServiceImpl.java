package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.User;
import com.weldnor.spms.mapper.UserMapper;
import com.weldnor.spms.repository.UserRepository;
import com.weldnor.spms.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void update(User user, long id) {
        User original = getById(id).orElseThrow();
        original = userMapper.mergeUsers(original, user);
        System.out.println(original.getPassword());
        userRepository.save(original);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
