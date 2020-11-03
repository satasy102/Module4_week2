package com.chanhtin.dao.impl;

import com.chanhtin.dao.ICommentDao;
import com.chanhtin.model.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class CommentDAO implements ICommentDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        try {
            Date date = new Date();

            TypedQuery<Comment> query = em.createQuery("select c from Comment AS c where DATE_FORMAT(c.time_post,'%Y-%M-%d')= DATE_FORMAT(:date,'%Y-%M-%d') ", Comment.class);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Comment findByID(Long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where  c.id=:id", Comment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Comment object) {
        if(object.getId() != null){
            em.merge(object);
        } else {
            em.persist(object);
        }
    }

    @Override
    public void remote(Long id) {
        Comment object = findByID(id);
        if(object != null){
            em.remove(object);
        }
    }
}
