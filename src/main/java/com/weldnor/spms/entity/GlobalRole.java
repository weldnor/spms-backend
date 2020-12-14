package com.weldnor.spms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "global_roles")
@Data
@NoArgsConstructor
public class GlobalRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long globalRoleId;
    private String name;

    @ManyToMany(mappedBy = "globalRoles")
    private List<User> users = new ArrayList<>();
}

