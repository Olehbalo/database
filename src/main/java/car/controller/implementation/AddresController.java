package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.Addres;
import car.service.implementation.AddresService;

import java.sql.SQLException;
import java.util.List;

public  class AddresController implements  AbstractController<Addres>{
    AddresService service = new  AddresService();
    @Override
    public  List<Addres> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public Addres findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(Addres entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, Addres entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}