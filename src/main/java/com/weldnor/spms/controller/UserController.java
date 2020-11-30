package com.weldnor.spms.controller;

import com.weldnor.spms.entity.User;
import com.weldnor.spms.exception.user.UserNotFoundException;
import com.weldnor.spms.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/users",
        produces = "application/json"
)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable(name = "id") long id) throws UserNotFoundException {
        return userService.getById(id)
                .orElseThrow();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable(name = "id") long id) throws UserNotFoundException {
        userService.deleteById(id);
    }
}
