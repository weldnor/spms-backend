package com.weldnor.spms.dto.user;

import com.weldnor.spms.dto.global_role.GlobalRoleDto;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long userId;
    private String username;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String password;
    private String email;
    private List<GlobalRoleDto> globalRoles;
}
