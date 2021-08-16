package bap.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bap.com.demo.model.Products;

public interface ProductRepository  extends JpaRepository<Products, Long> {

}
