package com.weldnor.spms.mapper.global_role;


import com.weldnor.spms.dto.global_role.GlobalRoleDto;
import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GlobalRoleMapper implements Mapper<GlobalRole, GlobalRoleDto> {

    private final ModelMapper mapper;

    public GlobalRoleMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public GlobalRole toEntity(GlobalRoleDto dto) {
        return mapper.map(dto, GlobalRole.class);
    }

    @Override
    public GlobalRoleDto toDto(GlobalRole entity) {
        return mapper.map(entity, GlobalRoleDto.class);
    }
}
