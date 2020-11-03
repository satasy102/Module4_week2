package com.chanhtin.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();

    T findByID(Long id);

    void save(T object);

    void remote(Long id);
}
