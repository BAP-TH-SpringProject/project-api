package bap.com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bap.com.demo.model.Products;
import bap.com.demo.repository.ProductRepository;

@Service
@Transactional
/**
 * The ProductService is the class that help admin can manage products
 * 
 * @author admin
 *
 */
public class ProductService {
    @Autowired
    private ProductRepository repoProduct;

    /**
     * get method
     * 
     * @return
     */
    public List<Products> findAll() {
        return repoProduct.findAll();
    }

    /**
     * save mothod
     * 
     * @param products
     * @return
     */
    public Products save(Products products) {
        return repoProduct.save(products);
    }

    /**
     * get product by id method
     * 
     * @param id
     * @return
     */
    public Optional<Products> findById(Long id) {
        return repoProduct.findById(id);
    }

    /**
     * delete method
     * 
     * @param id
     */
    public void remove(Long id) {
        repoProduct.deleteById(id);
    }

    /**
     * update method
     * 
     * @param id
     * @param products
     */
    public void update(Long id, Products products) {
        repoProduct.save(products);

    }

}
