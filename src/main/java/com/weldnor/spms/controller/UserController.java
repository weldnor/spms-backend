package com.weldnor.spms.controller;

import com.weldnor.spms.dto.UpdateUserDto;
import com.weldnor.spms.entity.User;
import com.weldnor.spms.exception.user.UserNotFoundException;
import com.weldnor.spms.mapper.UserMapper;
import com.weldnor.spms.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        path = "api/users",
        produces = "application/json"
)
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable(name = "id") long id) {
        return userService.getById(id)
                .orElseThrow();
    }

    @PostMapping(path = "/{id}")
    public void updateUser(@PathVariable(name = "id") long id, @RequestBody @Valid UpdateUserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userService.update(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteById(id);
    }
}
