package com.car.controller.implementation;

import com.car.controller.AbstractController;
import com.car.model.dao.AbstractDAO;

import java.sql.SQLException;
import java.util.List;

public class AbstractControllerImp<E> implements AbstractController<E> {
    private final AbstractDAO<E> dao;

    public AbstractControllerImp(AbstractDAO<E> dao) {

        this.dao = dao;
    }

    @Override
    public List<E> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public E get(Integer id) throws SQLException {
        return dao.get(id);
    }

    @Override
    public void create(E entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, E entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}