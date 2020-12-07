package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.repository.GlobalRoleRepository;
import com.weldnor.spms.service.GlobalRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalRoleServiceImpl implements GlobalRoleService {

    private final GlobalRoleRepository globalRoleRepository;

    public GlobalRoleServiceImpl(GlobalRoleRepository globalRoleRepository) {
        this.globalRoleRepository = globalRoleRepository;
    }

    @Override
    public List<GlobalRole> getAll() {
        return globalRoleRepository.findAll();
    }
}
