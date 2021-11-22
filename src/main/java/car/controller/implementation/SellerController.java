package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.Seller;
import car.service.implementation.SellerService;

import java.sql.SQLException;
import java.util.List;

public  class SellerController implements  AbstractController<Seller>{
    SellerService service = new  SellerService();
    @Override
    public  List<Seller> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public Seller findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(Seller entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, Seller entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}