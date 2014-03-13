package com.fms.services;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface GenericSvc<T> {
    Integer save(T obj);

    void update(T obj);

    void delete(T obj);

    T findById(int id);

    List<T> findAll();
}
