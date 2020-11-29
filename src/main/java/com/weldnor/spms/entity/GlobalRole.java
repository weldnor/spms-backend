package com.weldnor.spms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "global_roles")
@Data
@NoArgsConstructor
public class GlobalRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long globalRoleId;
    private String name;
}

