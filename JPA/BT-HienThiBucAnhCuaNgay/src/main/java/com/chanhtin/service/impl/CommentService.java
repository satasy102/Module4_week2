package com.chanhtin.service.impl;

import com.chanhtin.dao.ICommentDao;
import com.chanhtin.model.Comment;
import com.chanhtin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService implements BaseService<Comment> {

    @Autowired
    private ICommentDao commentDAO;

    @Override
    public List<Comment> findAll() {
        return commentDAO.findAll();
    }

    @Override
    public Comment findByID(Long id) {
        return commentDAO.findByID(id);
    }

    @Override
    public void save(Comment object) {
        commentDAO.save(object);
    }

    @Override
    public void remote(Long id) {
        commentDAO.remote(id);
    }
}
