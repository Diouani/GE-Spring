package com.jwt.repository.implementation;

import com.jwt.dao.RoleDao;
import com.jwt.dao.implementation.RoleDaoImpl;
import com.jwt.model.Role;
import com.jwt.repository.RoleRepo;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
@Transactional
public class RoleRepoImpl implements RoleRepo {

    @Autowired
    private RoleDao roleDao ;
@Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role find(int id) {
        return roleDao.find(id);
    }

    @Override
    public Role findByName(String roleName) {


        Query<Role> query = sessionFactory.getCurrentSession().createQuery("From role where name =:name",Role.class);
        query.setParameter("name", roleName);


        Role role = query.getSingleResult();


        return role;

    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    @Transactional
    public Role update(Role role) {
        return roleDao.update(role);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return roleDao.delete(id);
    }
}
