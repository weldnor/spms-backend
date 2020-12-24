package com.weldnor.spms.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UpdateUserDto {
    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[\\w ]*$")
    private String firstName;

    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[\\w ]*$")
    private String secondName;

    @Size(max = 20)
    @Pattern(regexp = "^[\\w ]*$")
    private String patronymic;

    @Size(min = 8, max = 40)
    @Pattern(regexp = "^[\\w ]*$")
    private String password;

    @Email
    private String email;
}
