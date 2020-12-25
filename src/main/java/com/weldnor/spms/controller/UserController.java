package com.weldnor.spms.controller;

import com.weldnor.spms.dto.user.UpdateUserDto;
import com.weldnor.spms.dto.user.UserDto;
import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.entity.User;
import com.weldnor.spms.mapper.user.UserMapper;
import com.weldnor.spms.service.GlobalRoleService;
import com.weldnor.spms.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(
        path = "api/users",
        produces = "application/json"
)
public class UserController {
    private final UserService userService;

    private final GlobalRoleService globalRoleService;

    private final UserMapper userMapper;

    public UserController(UserService userService, GlobalRoleService globalRoleService, UserMapper userMapper) {
        this.userService = userService;
        this.globalRoleService = globalRoleService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "")
    public List<UserDto> getAllUsers(
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String name
    ) {
        List<User> users = userService.getAll();
        Stream<User> userStream = users.stream();

        if (name != null) {
            userStream = userStream.filter(user -> user.getUsername().startsWith(name));
        }

        if (role != null && role.equals("admin")) {
            GlobalRole adminRole = globalRoleService.getByName("ADMIN").orElseThrow();
            userStream = userStream.filter(user -> user.getGlobalRoles().contains(adminRole));
        }

        if (role != null && role.equals("admin")) {
            GlobalRole adminRole = globalRoleService.getByName("USER").orElseThrow();
            userStream = userStream.filter(user -> user.getGlobalRoles().contains(adminRole));
        }

        return userMapper.toDto(userStream.collect(Collectors.toList()));
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
