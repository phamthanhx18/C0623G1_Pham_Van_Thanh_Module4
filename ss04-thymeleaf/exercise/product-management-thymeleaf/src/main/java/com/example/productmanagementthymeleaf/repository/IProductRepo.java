package com.example.productmanagementthymeleaf.repository;

import com.example.productmanagementthymeleaf.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> showAllProduct();
    void addProduct(Product product);
    void updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
    Product getProduct(Integer id);
    List<Product> searchProduct(String nameProduct);
}
