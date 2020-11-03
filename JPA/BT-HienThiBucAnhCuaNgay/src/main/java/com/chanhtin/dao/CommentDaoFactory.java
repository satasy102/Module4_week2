package com.chanhtin.dao;

import com.chanhtin.dao.impl.CommentDAO;
import com.chanhtin.model.Comment;

public class CommentDaoFactory {
    private static BaseDAO<Comment> singleton;

    public static synchronized BaseDAO<Comment> getInstance() {
        if (singleton == null) {
            singleton = new CommentDAO();
        }
        return singleton;
    }
}
