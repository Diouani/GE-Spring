package com.jwt.service.implementation;

import com.jwt.model.Role;
import com.jwt.repository.RoleRepo;
import com.jwt.repository.implementation.RoleRepoImpl;
import com.jwt.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;
    @Override
    @Transactional
    public Role add(Role role) {
        return roleRepo.add(role);
    }

    @Override
    public Role find(int id) {
        return roleRepo.find(id);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepo.findByName(roleName);
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.getAll();
    }

    @Override
    @Transactional
    public Role update(Role role) {
        return roleRepo.update(role);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return roleRepo.delete(id);
    }
}
