package car.service.implementation;

import car.model.dao.implementation.AddresDAO;
import car.model.entity.Addres;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class AddresService implements AbstractService<Addres> {

    private final AddresDAO dao = new AddresDAO();

    @Override
    public List<Addres> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Addres findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Addres entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Addres entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
