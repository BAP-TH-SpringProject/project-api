package bap.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bap.com.demo.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
