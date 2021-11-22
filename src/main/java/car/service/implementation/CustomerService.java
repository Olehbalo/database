package car.service.implementation;

import car.model.dao.implementation.CustomerDAO;
import car.model.entity.Customer;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class CustomerService implements AbstractService<Customer> {

    private final CustomerDAO dao = new CustomerDAO();

    @Override
    public List<Customer> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Customer findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Customer entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Customer entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
