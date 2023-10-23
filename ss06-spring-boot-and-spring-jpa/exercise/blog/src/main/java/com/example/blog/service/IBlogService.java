package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAllBlog(Pageable pageable);
    List<Blog> findAllBlog();
    void createBlog(Blog blog);
    String getSummaryById(Integer id);
    Blog findBlogById(Integer id);
    void updateBlog(Blog blog);
    void deleteBlog(Integer id);
    List<Blog> getBlogByCategoryId(Integer categoryId);
    List<Blog> searchBlogByTitleContaining(String title);
}
