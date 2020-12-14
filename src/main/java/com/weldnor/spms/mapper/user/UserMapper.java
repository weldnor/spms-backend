package com.weldnor.spms.mapper.user;

import com.weldnor.spms.dto.global_role.GlobalRoleDto;
import com.weldnor.spms.dto.user.NewUserDto;
import com.weldnor.spms.dto.user.UpdateUserDto;
import com.weldnor.spms.dto.user.UserDto;
import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.entity.User;
import com.weldnor.spms.mapper.global_role.GlobalRoleMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final GlobalRoleMapper globalRoleMapper;

    // fix circle dependencies
    public UserMapper(@Lazy PasswordEncoder passwordEncoder, ModelMapper mapper, GlobalRoleMapper globalRoleMapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.globalRoleMapper = globalRoleMapper;
    }

    @PostConstruct
    private void configMapper() {
        mapper.createTypeMap(User.class, UserDto.class)
                .addMappings(m -> m.skip(UserDto::setGlobalRoles));
    }

    public User toEntity(NewUserDto dto) {
        User user = mapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return user;
    }

    public User toEntity(UpdateUserDto dto) {
        User user = mapper.map(dto, User.class);
        if (dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = mapper.map(user, UserDto.class);
        List<GlobalRoleDto> globalRoleDtoList = globalRoleMapper.toDto(user.getGlobalRoles());
        userDto.setGlobalRoles(globalRoleDtoList);
        return userDto;
    }

    public List<UserDto> toDto(List<User> entityList) {
        List<UserDto> dtoList = new ArrayList<>();

        for (User entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public void merge(User original, User updated) {
        if (updated.getFirstName() != null) {
            original.setFirstName(updated.getFirstName());
        }
        if (updated.getSecondName() != null) {
            original.setSecondName(updated.getSecondName());
        }
        if (updated.getPatronymic() != null) {
            original.setPatronymic(updated.getPatronymic());
        }
        if (updated.getPassword() != null) {
            original.setPassword(updated.getPassword());
        }
        if (updated.getEmail() != null) {
            original.setEmail(updated.getEmail());
        }
    }
}
