package com.example.blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Lob
    @Column(name="content", length=512)
    private String content;
    private String summary;
    private String author;
    private String img;
    private String timePost;
    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String title, String content, String summary, String author, String img,Category category, String timePost) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.author = author;
        this.img = img;
        this.category = category;
        this.timePost = timePost;
    }

    public Blog(Integer id, String title, String content, String summary, String author, String img, String timePost, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.author = author;
        this.img = img;
        this.timePost = timePost;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
