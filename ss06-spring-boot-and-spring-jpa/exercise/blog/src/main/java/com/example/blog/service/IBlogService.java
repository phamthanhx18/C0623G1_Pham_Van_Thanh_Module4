package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAllBlog(int pageNumber, int pageSize);
    List<Blog> findAllBlog();
    void createBlog(Blog blog);
    String getSummaryById(Integer id);
    Blog findBlogById(Integer id);
    void updateBlog(Blog blog);
    void deleteBlog(Integer id);
    List<Blog> getBlogByCategoryId(Integer categoryId);
    List<Blog> searchBlogByTitleContaining(String title);
}
