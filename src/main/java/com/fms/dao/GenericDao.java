package com.fms.dao;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface GenericDao<T> {
    Integer save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}
