
package com.car.controller.implementation;


import com.car.model.dao.implementation.AddresDAOImpl;
import com.car.model.entity.Addres;


public class AddresControllerImpl extends AbstractControllerImp<Addres> {
    public AddresControllerImpl() {
        super(new AddresDAOImpl());
    }
}