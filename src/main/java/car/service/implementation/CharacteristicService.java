package car.service.implementation;

import car.model.dao.implementation.CharacteristicDAO;
import car.model.entity.Characteristic;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class CharacteristicService implements AbstractService<Characteristic> {

    private final CharacteristicDAO dao = new CharacteristicDAO();

    @Override
    public List<Characteristic> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Characteristic findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Characteristic entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Characteristic entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
