package com.chanhtin.service;

import com.chanhtin.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService {
    Page<Comment> findAll(Pageable pageable);

    Comment findByID(Long id);

    void save(Comment object);

    void remote(Long id);
}
