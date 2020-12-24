package com.weldnor.spms.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class NewUserDto {
    @Size(min = 3, max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$")
    @NotNull
    private String username;

    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[a-zA-Z ]*$")
    @NotNull
    private String firstName;

    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[\\w ]*$")
    @NotNull
    private String secondName;

    @Size(max = 20)
    @Pattern(regexp = "^[\\w ]*$")
    private String patronymic;

    @Size(min = 8, max = 40)
    @Pattern(regexp = "^[\\w ]*$")
    @NotNull
    private String password;

    @Email
    @NotNull
    private String email;
}
