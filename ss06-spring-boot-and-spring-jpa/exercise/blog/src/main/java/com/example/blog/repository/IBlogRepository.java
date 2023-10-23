package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(nativeQuery = true,value = "select summary from Blog where id = :param")
    String getSummaryById(@Param("param") Integer id);
    @Query(nativeQuery = true,value = "select * from Blog where id_category = :param")
    List<Blog> getBlogByCategoryId(@Param("param") Integer idCategory);
    List<Blog> searchBlogByTitleContaining(String title);
}
