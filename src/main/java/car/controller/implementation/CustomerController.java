package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.Customer;
import car.service.implementation.CustomerService;

import java.sql.SQLException;
import java.util.List;

public  class CustomerController implements  AbstractController<Customer>{
    CustomerService service = new  CustomerService();
    @Override
    public  List<Customer> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public Customer findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(Customer entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, Customer entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}