package com.weldnor.spms.service.impl;

import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.mapper.global_role.GlobalRoleMapper;
import com.weldnor.spms.repository.GlobalRoleRepository;
import com.weldnor.spms.service.GlobalRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlobalRoleServiceImpl implements GlobalRoleService {

    private final GlobalRoleRepository globalRoleRepository;
    private final GlobalRoleMapper globalRoleMapper;


    public GlobalRoleServiceImpl(GlobalRoleRepository globalRoleRepository, GlobalRoleMapper globalRoleMapper) {
        this.globalRoleRepository = globalRoleRepository;
        this.globalRoleMapper = globalRoleMapper;
    }

    @Override
    public List<GlobalRole> getAll() {
        return globalRoleRepository.findAll();
    }

    @Override
    public Optional<GlobalRole> getById(long id) {
        return globalRoleRepository.findByGlobalRoleId(id);
    }

    @Override
    public GlobalRole add(GlobalRole globalRole) {
        return globalRoleRepository.save(globalRole);
    }

    @Override
    public void update(GlobalRole globalRole, long id) {
        GlobalRole original = getById(id).orElseThrow();
        globalRoleMapper.merge(original, globalRole);
        globalRoleRepository.save(original);
    }

    @Override
    public void deleteById(long id) {
        globalRoleRepository.deleteById(id);
    }
}
