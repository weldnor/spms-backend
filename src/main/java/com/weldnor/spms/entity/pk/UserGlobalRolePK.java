package com.weldnor.spms.entity.pk;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserGlobalRolePK implements Serializable {
    private long userId;
    private long globalRoleId;
}
