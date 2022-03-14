package com.jwt.dao;

import com.jwt.model.Users;


import java.util.List;

public interface UserDao {


    Users find(long id);
    List<Users> getAll();
    Users add(Users user);
    Users update(Users user);
    boolean delete(long id);
}
