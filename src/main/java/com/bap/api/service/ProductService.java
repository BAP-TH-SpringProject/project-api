package com.bap.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.api.model.entity.Products;
import com.bap.api.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Products> getAll() {
        return repository.findAll();
    }
}
