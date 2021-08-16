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
public class ProductService {
    @Autowired
    private ProductRepository repoProduct;

    public List<Products> findAll(){
        return repoProduct.findAll();
    }

    public Products save(Products products) {
        return repoProduct.save(products);
    }

    public Optional<Products> findById(Long id) {
        return repoProduct.findById(id);
    }


    public void remove(Long id) {
    	repoProduct.deleteById(id);
    }

	public void update(Long id, Products products) {
		repoProduct.save(products);

	}

}
