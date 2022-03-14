package com.jwt.dao.implementation;


import com.jwt.dao.AddressDao;
import com.jwt.model.Address;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository

public class AddressDaoImpl implements AddressDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public Address add(Address address) {
        sessionFactory.getCurrentSession().save(address);
        return address;
    }

    @Override
    public Address find(long id) {
      Address address = (Address) sessionFactory.getCurrentSession().get(Address.class,id);
        return address;

    }

    @Override
    public List getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Address").list();

    }

    @Override
    @Transactional
    public Address update(Address address) {
        sessionFactory.getCurrentSession().update(address);
        return address;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        Address address = (Address) sessionFactory.getCurrentSession().load(
                Address.class, id);
        if (  address !=  null) {
            this.sessionFactory.getCurrentSession().delete(address);
        }
        return true;
    }
}
