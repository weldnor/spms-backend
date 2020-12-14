package com.weldnor.spms.controller;

import com.weldnor.spms.dto.global_role.GlobalRoleDto;
import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.mapper.global_role.GlobalRoleMapper;
import com.weldnor.spms.service.GlobalRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/global_roles",
        produces = "application/json"
)
public class GlobalRoleController {

    private final GlobalRoleService globalRoleService;
    private final GlobalRoleMapper globalRoleMapper;

    public GlobalRoleController(GlobalRoleService globalRoleService, GlobalRoleMapper globalRoleMapper) {
        this.globalRoleService = globalRoleService;
        this.globalRoleMapper = globalRoleMapper;
    }

    @GetMapping(path = "")
    public List<GlobalRoleDto> getAllGlobalRoles() {
        List<GlobalRole> roles = globalRoleService.getAll();
        return globalRoleMapper.toDto(roles);
    }
}
