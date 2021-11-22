package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.CarDealership;
import car.service.implementation.CarDealershipService;

import java.sql.SQLException;
import java.util.List;

public  class CarDealershipController implements  AbstractController<CarDealership>{
    CarDealershipService service = new CarDealershipService();
    @Override
    public  List<CarDealership> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public CarDealership findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(CarDealership entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, CarDealership entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}