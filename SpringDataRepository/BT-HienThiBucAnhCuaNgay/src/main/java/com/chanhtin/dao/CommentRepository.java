package com.chanhtin.dao;

import com.chanhtin.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {
}
