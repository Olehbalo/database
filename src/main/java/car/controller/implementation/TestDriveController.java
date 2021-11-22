package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.TestDrive;
import car.service.implementation.TestDriveService;

import java.sql.SQLException;
import java.util.List;

public  class TestDriveController implements  AbstractController<TestDrive>{
    TestDriveService service = new  TestDriveService();
    @Override
    public  List<TestDrive> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public TestDrive findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(TestDrive entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, TestDrive entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}