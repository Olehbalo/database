package com.car.model.dao.implementation;

import com.car.model.entity.Customer;

public class CustomerDAOImpl extends AbstractDAOImpl<Customer> {
    public CustomerDAOImpl() {
        super(Customer.class);
    }
}