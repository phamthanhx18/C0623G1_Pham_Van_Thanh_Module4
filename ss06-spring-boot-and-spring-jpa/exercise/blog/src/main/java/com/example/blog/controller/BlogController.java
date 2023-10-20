package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ModelAndView showHome(Model model){
        return new ModelAndView("index","blogs",blogService.findAllBlog());
    }

    @GetMapping("/blog/list")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int pageNumber,
                           @RequestParam(defaultValue = "1") int pageSize) {
        Page<Blog> blogPage = blogService.findAllBlog(pageNumber, pageSize);
        model.addAttribute("blogs", blogPage.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", blogPage.getTotalPages());
        return "list";
    }

    @GetMapping("/blog/add")
    public ModelAndView showFormAdd(Model model){
        model.addAttribute("category",categoryService.findAllCategory());
        return new ModelAndView("add","blog",new Blog());
    }

    @PostMapping("/blog/add")
    public String saveBlog(@ModelAttribute Blog blog){
        blogService.createBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/view")
    public ModelAndView viewDetailBlog(@PathVariable Integer id){
        return new ModelAndView("view","blog", blogService.findBlogById(id));
    }

    @GetMapping("/blog/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("category",categoryService.findAllCategory());
        return new ModelAndView("edit","blog", blogService.findBlogById(id));
    }

    @PostMapping("/blog/{id}/edit")
    public String updateBlog(@ModelAttribute Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/blog/{id}/delete")
    public String deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return "redirect:/blog/list";
    }

    @PostMapping("/blog/search")
    public ModelAndView searchByTitle(@RequestParam(value = "title-search") String titleSearch) {
        return new ModelAndView("index","blogs", blogService.searchBlogByTitleContaining(titleSearch));
    }
}
