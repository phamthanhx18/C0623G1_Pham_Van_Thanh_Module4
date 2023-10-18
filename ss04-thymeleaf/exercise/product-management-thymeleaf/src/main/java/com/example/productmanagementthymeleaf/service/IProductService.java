package com.example.productmanagementthymeleaf.service;

import com.example.productmanagementthymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAllProduct();
    void addProduct(Product product);
    void updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
    Product getProduct(Integer id);
    List<Product> searchProduct(String nameProduct);
}
