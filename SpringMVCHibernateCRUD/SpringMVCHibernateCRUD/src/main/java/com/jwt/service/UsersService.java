package com.jwt.service;

import com.jwt.model.Users;


import java.util.List;

public interface UsersService {
    int login(String Email, String Password);
    void logout();
    boolean updatePasswordById(String newPassword, long user_id);
    Users find(long id);
    Users findByEmail(String Email);
    List<Users> getAll();
    Users add(Users user);
    Users update(Users user);
    boolean delete(long id);
}
