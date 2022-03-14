package com.jwt.dao.implementation;


import com.jwt.dao.RoleDao;
import com.jwt.model.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository

public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public Role add(Role Role) {
        sessionFactory.getCurrentSession().save(Role);
        return Role;
    }

    @Override
    public Role find(int id) {
        Role role = (Role) sessionFactory.getCurrentSession().get(Role.class,id);
        return role;

    }

    @Override
    public List<Role> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Role").list();

    }

    @Override
    @Transactional
    public Role update(Role Role) {
        sessionFactory.getCurrentSession().update(Role);
        return Role;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        Role Role = (Role) sessionFactory.getCurrentSession().load(
                Role.class, id);
        if (  Role !=  null) {
            this.sessionFactory.getCurrentSession().delete(Role);
        }
        return true;
    }
}
