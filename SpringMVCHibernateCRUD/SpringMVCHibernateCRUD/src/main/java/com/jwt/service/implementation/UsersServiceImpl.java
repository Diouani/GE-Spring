package com.jwt.service.implementation;

import com.jwt.model.Users;
import com.jwt.repository.UserRepo;
import com.jwt.repository.implementation.UserRepoImpl;
import com.jwt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service


public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserRepo userRepo ;
    @Override
    public int login(String Email, String Password) {
        return userRepo.login(Email,Password);
    }

    @Override
    public void logout() {

    }

    @Override
    @Transactional
    public boolean updatePasswordById(String newPassword, long user_id) {
        return userRepo.updatePasswordById(newPassword, user_id);
    }

    @Override
    public Users find(long id) {
        return userRepo.find(id);
    }

    @Override
    public Users findByEmail(String Email) {
        return userRepo.findByEmail(Email);
    }

    @Override
    public List<Users> getAll() {
        return userRepo.getAll();
    }

    @Override
    @Transactional
    public Users add(Users user) {
        return userRepo.add(user);
    }

    @Override
    @Transactional
    public Users update(Users user) {
        return userRepo.update(user);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return userRepo.delete(id);
    }
}
