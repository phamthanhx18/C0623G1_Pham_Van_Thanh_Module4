package com.example.add_to_cart.controller;

import com.example.add_to_cart.dto.CartDto;
import com.example.add_to_cart.model.Product;
import com.example.add_to_cart.service.IProductService;
import com.example.add_to_cart.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showShop() {
        return new ModelAndView("index","products", productService.findAll());
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add","product", new Product());
    }

    @PostMapping("/add")
    public ModelAndView saveProduct(@ModelAttribute Product product, @RequestParam("image-upload") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(fileName,multipartFile);
        product.setImage(fileName);
        productService.saveProduct(product);
        return new ModelAndView("add","product", new Product());
    }

    @GetMapping("/product/{id}")
    public ModelAndView detailProduct(@PathVariable Long id){
        return new ModelAndView("detail","product", productService.findById(id).get());
    }

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cartDto){
        Product product = productService.findById(id).get();
        cartDto.addProduct(product);
            return "redirect:/cart";
    }
}