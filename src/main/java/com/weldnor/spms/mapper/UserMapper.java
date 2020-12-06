package com.weldnor.spms.mapper;

import com.weldnor.spms.dto.NewUserDto;
import com.weldnor.spms.dto.UpdateUserDto;
import com.weldnor.spms.entity.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    // fix circle dependencies
    public UserMapper(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User mapToUser(NewUserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setSecondName(dto.getSecondName());
        user.setPatronymic(dto.getPatronymic());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        return user;
    }

    public User mapToUser(UpdateUserDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setSecondName(dto.getSecondName());
        user.setPatronymic(dto.getPatronymic());
        if (dto.getPassword() != null) {
            System.out.println(dto.getPassword());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        user.setEmail(dto.getEmail());
        return user;
    }

    public User mergeUsers(User original, User updated) {
        if (updated.getFirstName() != null) {
            original.setFirstName(updated.getFirstName());
        }
        if (updated.getSecondName() != null) {
            original.setSecondName(updated.getSecondName());
        }
        if (updated.getPatronymic() != null) {
            original.setPatronymic(updated.getPatronymic());
        }
        if (updated.getPassword() != null) {
            original.setPassword(updated.getPassword());
        }
        if (updated.getEmail() != null) {
            original.setEmail(updated.getEmail());
        }
        return original;
    }
}
