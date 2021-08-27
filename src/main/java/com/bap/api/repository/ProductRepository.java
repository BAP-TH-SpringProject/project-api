package com.bap.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long> {
}
