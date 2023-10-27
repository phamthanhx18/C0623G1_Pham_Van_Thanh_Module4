package com.example.add_to_cart.service;
import com.example.add_to_cart.model.Product;

import java.util.Optional;
public interface IProductService {
    Iterable<Product> findAll();
    void saveProduct(Product product);
    Optional<Product> findById(Long id);
}
