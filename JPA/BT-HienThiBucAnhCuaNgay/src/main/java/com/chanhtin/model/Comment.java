package com.chanhtin.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "comment")
public class Comment implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String feedback;
    private int rating;
    private Date time_post = new java.util.Date();
    private int likes;

    public Comment(Long id, String author, String feedback, int rating) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.rating = rating;
    }

    public Comment() {
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long image_id) {
        this.id = image_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feddback) {
        this.feedback = feddback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getTime_post() {
        return time_post;
    }

    public void setTime_post(Date time_post) {
        this.time_post = time_post;
    }
}
