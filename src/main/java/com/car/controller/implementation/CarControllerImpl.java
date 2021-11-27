
package com.car.controller.implementation;


import com.car.model.dao.implementation.CarDAOImpl;
import com.car.model.entity.Car;


public class CarControllerImpl extends AbstractControllerImp<Car> {
    public CarControllerImpl() {
        super(new CarDAOImpl());
    }
}