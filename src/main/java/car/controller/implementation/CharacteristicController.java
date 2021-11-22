package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.Characteristic;
import car.service.implementation.CharacteristicService;

import java.sql.SQLException;
import java.util.List;

public  class CharacteristicController implements  AbstractController<Characteristic>{
    CharacteristicService service = new  CharacteristicService();
    @Override
    public  List<Characteristic> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public Characteristic findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(Characteristic entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, Characteristic entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}