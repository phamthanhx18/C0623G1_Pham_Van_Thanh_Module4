package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAllProduct();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Integer id);
    Product getProduct(Integer id);
    List<Product> searchProduct(String nameProduct);
}
