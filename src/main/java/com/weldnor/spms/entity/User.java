package com.weldnor.spms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String password;
    private String email;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole role;
}
