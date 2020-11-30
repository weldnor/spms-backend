package com.weldnor.spms.entity;

import com.weldnor.spms.entity.pk.UserGlobalRolePK;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_global_roles")
@IdClass(UserGlobalRolePK.class)
@Data
@NoArgsConstructor
public class UserGlobalRole {
    @Id
    @Column(name = "user_id")
    private long userId;

    @Id
    @Column(name = "global_role_id")
    private long globalRoleId;
}
