package com.jwt.dao.implementation;


import com.jwt.dao.UserDao;
import com.jwt.model.Users;
import com.jwt.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

 import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository

public class UsersDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public Users add(Users Users) {
        sessionFactory.getCurrentSession().save(Users);
        return Users;
    }

    @Override
    public Users find(long id) {
        Users role = (Users) sessionFactory.getCurrentSession().get(Users.class,id);
        return role;

    }

    @Override
    public List<Users> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Users").list();

    }

    @Override
    @Transactional
    public Users update(Users Users) {
        sessionFactory.getCurrentSession().update(Users);
        return Users;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        Users Users = (Users) sessionFactory.getCurrentSession().load(
                Users.class, id);
        if (  Users !=  null) {
            this.sessionFactory.getCurrentSession().delete(Users);
        }
        return true;
    }
}
