
package com.car.controller.implementation;


import com.car.model.dao.implementation.CarTypeDAOImpl;
import com.car.model.entity.CarType;


public class CarTypeControllerImpl extends AbstractControllerImp<CarType> {
    public CarTypeControllerImpl() {
        super(new CarTypeDAOImpl());
    }
}