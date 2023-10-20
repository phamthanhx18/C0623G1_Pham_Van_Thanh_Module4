package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAllBlog(int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "timePost");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }


    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public String getSummaryById(Integer id) {
        return blogRepository.getSummaryById(id);
    }

    @Override
    public Blog findBlogById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> getBlogByCategoryId(Integer categoryId) {
        return blogRepository.getBlogByCategoryId(categoryId);
    }

    @Override
    public List<Blog> searchBlogByTitleContaining(String title) {
        return blogRepository.searchBlogByTitleContaining(title);
    }
}
