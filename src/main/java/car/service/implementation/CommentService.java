package car.service.implementation;

import car.model.dao.implementation.СommentDAO;
import car.model.entity.Comment;
import car.service.AbstractService;


import java.sql.SQLException;
import java.util.List;

public class CommentService implements AbstractService<Comment> {

    private final СommentDAO dao = new СommentDAO();

    @Override
    public List<Comment> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Comment findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Comment entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Comment entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
