package car.service.implementation;

import car.model.dao.implementation.CarDAO;
import car.model.entity.Car;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class CarService implements AbstractService<Car> {

    private final CarDAO dao = new CarDAO();

    @Override
    public List<Car> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Car findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Car entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Car entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
