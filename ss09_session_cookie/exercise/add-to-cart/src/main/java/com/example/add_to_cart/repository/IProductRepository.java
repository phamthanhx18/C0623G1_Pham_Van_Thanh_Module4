package com.example.add_to_cart.repository;

import com.example.add_to_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
