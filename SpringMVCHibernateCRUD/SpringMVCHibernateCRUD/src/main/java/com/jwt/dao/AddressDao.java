package com.jwt.dao;

import com.jwt.model.Address;


import java.util.List;

public interface AddressDao {

    Address add(Address address);
    Address find(long id);
    List<Address> getAll();
    Address update(Address address);
    boolean delete(long id);
}
