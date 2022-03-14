package com.jwt.repository.implementation;

import com.jwt.dao.AddressDao;
import com.jwt.dao.implementation.AddressDaoImpl;
import com.jwt.model.Address;
import com.jwt.repository.AddressRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository

public class AddressRepoImpl implements AddressRepo {
    @Autowired
    private AddressDao addressDao ;

    @Override
    @Transactional
    public Address add(Address address) {
        return addressDao.add(address);
    }

    @Override
    public Address find(long id) {
        return addressDao.find(id);
    }

    @Override
    public List<Address> getAll() {
        return addressDao.getAll();
    }

    @Override
    @Transactional
    public Address update(Address address) {
        return addressDao.update(address);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return addressDao.delete(id);
    }
}
