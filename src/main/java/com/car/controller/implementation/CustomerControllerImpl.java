
package com.car.controller.implementation;


import com.car.model.dao.implementation.CustomerDAOImpl;
import com.car.model.entity.Customer;


public class CustomerControllerImpl extends AbstractControllerImp<Customer> {
    public CustomerControllerImpl() {
        super(new CustomerDAOImpl());
    }
}