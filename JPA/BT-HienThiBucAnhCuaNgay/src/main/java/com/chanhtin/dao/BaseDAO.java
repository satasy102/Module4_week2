package com.chanhtin.dao;

import com.chanhtin.model.Comment;

import java.util.List;

public interface BaseDAO<T> {
    List<T> findAll();

    T findByID(Long id);

    void save(Comment object);

    void remote(Long id);
}
