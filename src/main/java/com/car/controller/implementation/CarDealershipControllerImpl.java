
package com.car.controller.implementation;


import com.car.model.dao.implementation.CarDealershipDAOImp;
import com.car.model.entity.CarDealership;



public class CarDealershipControllerImpl extends AbstractControllerImp<CarDealership> {
    public CarDealershipControllerImpl() {
        super(new CarDealershipDAOImp());
    }
}