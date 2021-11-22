package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.CarType;
import car.service.implementation.CarTypeService;

import java.sql.SQLException;
import java.util.List;

public  class CarTypeController implements  AbstractController<CarType>{
    CarTypeService service = new  CarTypeService();
    @Override
    public  List<CarType> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public CarType findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(CarType entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, CarType entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}