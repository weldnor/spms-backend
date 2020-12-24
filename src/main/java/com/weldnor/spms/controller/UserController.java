package com.weldnor.spms.controller;

import com.weldnor.spms.dto.user.UpdateUserDto;
import com.weldnor.spms.dto.user.UserDto;
import com.weldnor.spms.entity.User;
import com.weldnor.spms.mapper.user.UserMapper;
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
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAll();
        return userMapper.toDto(users);
    }

    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable(name = "id") long id) {
        User user = userService.getById(id).orElseThrow();
        return userMapper.toDto(user);
    }

    @PostMapping(path = "/{id}")
    public void updateUser(@PathVariable(name = "id") long id, @RequestBody @Valid UpdateUserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userService.update(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteById(id);
    }
}
