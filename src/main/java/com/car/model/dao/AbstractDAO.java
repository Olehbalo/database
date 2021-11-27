package com.car.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<E> {
    List<E>  findAll() throws SQLException;

    E get(Integer id) throws SQLException;

    void update(Integer id, E entity) throws SQLException;

    void create(E entity) throws SQLException;

    void delete(Integer id) throws SQLException;
}
