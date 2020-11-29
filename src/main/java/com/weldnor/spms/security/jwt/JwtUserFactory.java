package com.weldnor.spms.security.jwt;

import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getGlobalRoles())
        );

    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<GlobalRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (GlobalRole role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }
}
