package com.weldnor.spms.mapper.global_role;


import com.weldnor.spms.dto.global_role.GlobalRoleDto;
import com.weldnor.spms.dto.global_role.NewGlobalRoleDto;
import com.weldnor.spms.dto.global_role.UpdateGlobalRoleDto;
import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.entity.Project;
import com.weldnor.spms.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GlobalRoleMapper {

    private final ModelMapper mapper;

    public GlobalRoleMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public GlobalRole toEntity(GlobalRoleDto dto) {
        return mapper.map(dto, GlobalRole.class);
    }

    public GlobalRole toEntity(NewGlobalRoleDto dto) {
        return mapper.map(dto, GlobalRole.class);
    }

    public GlobalRole toEntity(UpdateGlobalRoleDto dto) {
        return mapper.map(dto, GlobalRole.class);
    }

    public GlobalRoleDto toDto(GlobalRole entity) {
        return mapper.map(entity, GlobalRoleDto.class);
    }

    public List<GlobalRoleDto> toDto(List<GlobalRole> entityList) {
        List<GlobalRoleDto> dtoList = new ArrayList<>();

        for (GlobalRole entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public void merge(GlobalRole original, GlobalRole updated) {
        if (updated.getName() != null) {
            original.setName(updated.getName());
        }
    }
}
