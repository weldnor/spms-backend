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

    @DeleteMapping(path = "/{id}")
    public User getAllUsers(@PathVariable(name = "id") long id) throws UserNotFoundException {
        return userService.deleteById(id)
                .orElseThrow(() -> new UserNotFoundException("user with id " + id + " not found"));
    }
}
