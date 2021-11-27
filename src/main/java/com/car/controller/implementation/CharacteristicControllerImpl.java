
package com.car.controller.implementation;


import com.car.model.dao.implementation.CharacteristicDAOImpl;
import com.car.model.entity.Characteristic;


public class CharacteristicControllerImpl extends AbstractControllerImp<Characteristic> {
    public CharacteristicControllerImpl() {
        super(new CharacteristicDAOImpl());
    }
}