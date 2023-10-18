package com.example.productmanagementthymeleaf.service;

import com.example.productmanagementthymeleaf.model.Product;
import com.example.productmanagementthymeleaf.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepo productRepo;
    @Override
    public List<Product> showAllProduct() {
        return productRepo.showAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        productRepo.updateProduct(id,product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteProduct(id);
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepo.getProduct(id);
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        return productRepo.searchProduct(nameProduct);
    }
}
