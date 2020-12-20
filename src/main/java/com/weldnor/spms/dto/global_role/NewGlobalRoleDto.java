package com.weldnor.spms.dto.global_role;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewGlobalRoleDto {
    @Size(min = 1, max = 40)
    @NotNull
    private String name;
}
