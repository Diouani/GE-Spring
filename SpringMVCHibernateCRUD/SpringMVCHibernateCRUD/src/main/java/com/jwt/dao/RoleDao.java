package com.jwt.dao;

import com.jwt.model.Role;


import java.util.List;

public interface RoleDao {
    Role add(Role role);
    Role find(int id);
    List<Role> getAll();
    Role update(Role role);
    boolean delete(long id);
}
