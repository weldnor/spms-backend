package com.weldnor.spms.controller;

import com.weldnor.spms.dto.global_role.GlobalRoleDto;
import com.weldnor.spms.dto.global_role.NewGlobalRoleDto;
import com.weldnor.spms.dto.global_role.UpdateGlobalRoleDto;
import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.mapper.global_role.GlobalRoleMapper;
import com.weldnor.spms.service.GlobalRoleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(path = "/{id}")
    public GlobalRoleDto getGlobalRole(@PathVariable(name = "id") long id) {
        GlobalRole role = globalRoleService.getById(id).orElseThrow();
        return globalRoleMapper.toDto(role);
    }

    @PutMapping(path = "")
    public GlobalRoleDto addGlobalRole(@RequestBody @Valid NewGlobalRoleDto newGlobalRoleDto) {
        GlobalRole role = globalRoleMapper.toEntity(newGlobalRoleDto);
        role = globalRoleService.add(role);
        return globalRoleMapper.toDto(role);
    }

    @PostMapping(path = "{id}")
    public void updateGlobalRole(@PathVariable(name = "id") long id, @RequestBody @Valid UpdateGlobalRoleDto updateGlobalRoleDto) {
        GlobalRole role = globalRoleMapper.toEntity(updateGlobalRoleDto);
        globalRoleService.update(role, id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteGlobalRole(@PathVariable(name = "id") long id) {
        globalRoleService.deleteById(id);
    }
}
