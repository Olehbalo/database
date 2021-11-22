package car.service.implementation;

import car.model.dao.implementation.CarTypeDAO;
import car.model.entity.CarType;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class CarTypeService implements AbstractService<CarType> {

    private final CarTypeDAO dao = new CarTypeDAO();

    @Override
    public List<CarType> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CarType findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(CarType entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CarType entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
