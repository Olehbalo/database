package car.service.implementation;

import car.model.dao.implementation.SiteDAO;
import car.model.entity.Site;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class SiteService implements AbstractService<Site> {

    private final SiteDAO dao = new SiteDAO();

    @Override
    public List<Site> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Site findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Site entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Site entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
