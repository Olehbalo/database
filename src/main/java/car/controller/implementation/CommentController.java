package car.controller.implementation;

import  car.controller.AbstractController;
import car.model.entity.Comment;
import car.service.implementation.CommentService;

import java.sql.SQLException;
import java.util.List;

public  class CommentController implements  AbstractController<Comment>{
    CommentService service = new  CommentService();
    @Override
    public  List<Comment> findAll() throws SQLException{
        return  service.findAll();
    }

    @Override
    public Comment findById(Integer id) throws  SQLException{
        return  service.findById(id);
    }
    @Override
    public void create(Comment entity) throws  SQLException{
        service.create(entity);
    }
    @Override
    public void update(Integer id, Comment entity) throws SQLException {
        service.update(id, entity);
    }
    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}