package car.service.implementation;

import car.model.dao.implementation.CarDealershipDAO;
import car.model.entity.CarDealership;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class CarDealershipService implements AbstractService<CarDealership> {

    private final CarDealershipDAO dao = new CarDealershipDAO();

    @Override
    public List<CarDealership> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CarDealership findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(CarDealership entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CarDealership entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
