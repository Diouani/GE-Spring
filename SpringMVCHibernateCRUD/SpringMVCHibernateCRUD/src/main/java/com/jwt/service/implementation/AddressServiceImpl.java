package com.jwt.service.implementation;

import com.jwt.model.Address;
import com.jwt.repository.AddressRepo;
import com.jwt.repository.implementation.AddressRepoImpl;
import com.jwt.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service

public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo ;
    @Override
    @Transactional
    public Address add(Address address) {
        return addressRepo.add(address);
    }

    @Override
    public Address find(long id) {
        return addressRepo.find(id);
    }

    @Override
    public List<Address> getAll() {
        return addressRepo.getAll();
    }

    @Override
    public Address update(Address address) {
        return addressRepo.update(address);
    }

    @Override

    public boolean delete(long id) {
        return addressRepo.delete(id);
    }
}
