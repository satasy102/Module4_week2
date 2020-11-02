package com.codegym.model;


import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String shortContent;
    private String fullContent;
    private String imageUrl;
    private int views;
    private int likes;

    public Blog() {
    }

    public Blog(Long id, String title, String shortContent, String fullContent, String imageUrl, int views, int likes) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.imageUrl = imageUrl;
        this.views = views;
        this.likes = likes;
    }

    public Blog(String title, String shortContent, String fullContent, String imageUrl, int views, int likes) {
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.imageUrl = imageUrl;
        this.views = views;
        this.likes = likes;
    }

    public Blog(Long id, String title, String shortContent, String fullContent, String imageUrl) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.imageUrl = imageUrl;
    }

    public Blog(String title, String shortContent, String fullContent, String imageUrl) {
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
