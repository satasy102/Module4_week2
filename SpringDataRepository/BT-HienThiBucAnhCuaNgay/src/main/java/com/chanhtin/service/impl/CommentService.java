package com.chanhtin.service.impl;

import com.chanhtin.dao.CommentRepository;
import com.chanhtin.model.Comment;
import com.chanhtin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CommentService implements BaseService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment findByID(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment object) {
        commentRepository.save(object);
    }

    @Override
    public void remote(Long id) {
        commentRepository.deleteById(id);
    }
}
