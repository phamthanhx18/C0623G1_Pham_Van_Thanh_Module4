package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ModelAndView showListCategory(){
        return new ModelAndView("category-list","category",categoryService.findAllCategory());
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd(){
        return new ModelAndView("add-category","category",new Category());
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute Category category){
        categoryService.createCategory(category);
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String viewDetailCategory(Model model, @PathVariable Integer id){
        model.addAttribute("category", categoryService.findCategoryById(id));
        model.addAttribute("blogs", blogService.getBlogByCategoryId(id));
        return "view-category";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id){
        return new ModelAndView("edit-category","category", categoryService.findCategoryById(id));
    }

    @PostMapping("/{id}/edit")
    public String updateCategory(@ModelAttribute Category category){
        categoryService.updateCategory(category);
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/list";
    }
}
