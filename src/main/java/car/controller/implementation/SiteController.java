package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.Site;
import car.service.implementation.SiteService;

import java.sql.SQLException;
import java.util.List;

public  class SiteController implements  AbstractController<Site>{
    SiteService service = new  SiteService();
    @Override
    public  List<Site> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public Site findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(Site entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, Site entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}