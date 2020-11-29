package com.weldnor.spms.dto;

import com.weldnor.spms.entity.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewUserDto {
    @Size(min = 3, max = 40)
    private String username;

    @Size(min = 1, max = 20)
    private String firstName;

    @Size(min = 1, max = 20)
    private String secondName;

    @Size(max = 20)
    private String patronymic;

    @Size(min = 8, max = 40)
    private String password;

    @Email
    @NotNull
    private String email;

    public User mapToUser() {
        User user = new User();
        user.setUsername(this.username);
        user.setFirstName(this.firstName);
        user.setSecondName(this.secondName);
        user.setPatronymic(this.patronymic);
        user.setPassword(this.password);
        user.setEmail(this.email);
        return user;
    }
}
