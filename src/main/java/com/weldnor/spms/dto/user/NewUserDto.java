package com.weldnor.spms.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewUserDto {
    @Size(min = 3, max = 40)
    @NotNull
    private String username;

    @Size(min = 1, max = 20)
    @NotNull
    private String firstName;

    @Size(min = 1, max = 20)
    @NotNull
    private String secondName;

    @Size(max = 20)
    private String patronymic;

    @Size(min = 8, max = 40)
    @NotNull
    private String password;

    @Email
    @NotNull
    private String email;
}
