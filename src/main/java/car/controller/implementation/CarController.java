package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.Car;
import car.service.implementation.CarService;

import java.sql.SQLException;
import java.util.List;

public  class CarController implements  AbstractController<Car>{
    CarService service = new  CarService();
    @Override
    public  List<Car> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public Car findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(Car entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, Car entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}