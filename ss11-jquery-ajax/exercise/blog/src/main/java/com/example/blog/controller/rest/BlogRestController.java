package com.example.blog.controller.rest;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> getAllBlog(@PageableDefault(value = 2,sort = "timePost",direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> blogs = blogService.findAllBlog(pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    // Get Blog By Id
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getDetailBlog(@PathVariable Integer id){
       Optional<Blog> blog = blogService.findBlog(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchByTitle(@RequestParam(value = "title") String titleSearch) {
        List<Blog> blogs = blogService.searchBlogByTitleContaining(titleSearch);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
