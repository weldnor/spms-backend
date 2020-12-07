package com.weldnor.spms.controller;

import com.weldnor.spms.entity.GlobalRole;
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

    public GlobalRoleController(GlobalRoleService globalRoleService) {
        this.globalRoleService = globalRoleService;
    }

    @GetMapping(path = "")
    public List<GlobalRole> getAllGlobalRoles() {
        return globalRoleService.getAll();
    }
}
