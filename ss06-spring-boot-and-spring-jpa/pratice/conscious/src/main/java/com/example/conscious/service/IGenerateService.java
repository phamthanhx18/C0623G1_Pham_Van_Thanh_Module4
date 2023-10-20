package com.example.conscious.service;

import com.example.conscious.model.Customer;
import com.example.conscious.model.Province;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<E> {
    Iterable<E> findAll();
    void save(Province province);
    Optional<Province> findById(Long id);
    void remove(Long id);
    Iterable<Customer> findAllByProvince(Province province);
}
