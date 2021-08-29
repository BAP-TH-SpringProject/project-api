package com.bap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query("select u from Products u where u.id = ?1")
    Products findByID(Long id);
}
