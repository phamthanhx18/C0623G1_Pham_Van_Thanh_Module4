package com.example.productmanagementthymeleaf.controller;

import com.example.productmanagementthymeleaf.model.Product;
import com.example.productmanagementthymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index","products",productService.showAllProduct());
    }

    @GetMapping("/product/add")
    public ModelAndView showFormAddProduct(){
        return new ModelAndView("add","product",new Product());
    }

    @PostMapping("/product/add")
    public ModelAndView saveProduct(@ModelAttribute Product product){
        productService.addProduct(product);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView showFormEditProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return new ModelAndView("edit","product", product);
    }

    @PostMapping("/product/{id}/edit")
    public ModelAndView updateProduct(@ModelAttribute Product product,@PathVariable Integer id){
        productService.updateProduct(id,product);
        return new ModelAndView("edit","product", product);
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView showViewProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return new ModelAndView("view","product", product);
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/product/search")
    public ModelAndView showResultSearch(@RequestParam(value = "name-search") String nameSearch){
        List<Product> products = productService.searchProduct(nameSearch);
        return new ModelAndView("index","products",products);
    }
}
