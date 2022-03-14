package com.jwt.service;

import com.jwt.model.Role;


import java.util.List;

public interface RoleService {
    Role add(Role role);
    Role find(int id);
    Role findByName(String roleName);
    List<Role> getAll();
    Role update(Role role);
    boolean delete(long id);
}
