
package com.car.controller.implementation;


import com.car.model.dao.implementation.TestDriveDAOImpl;
import com.car.model.entity.TestDrive;


public class TestDriveControllerImpl extends AbstractControllerImp<TestDrive> {
    public TestDriveControllerImpl() {
        super(new TestDriveDAOImpl());
    }
}