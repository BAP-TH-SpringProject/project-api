package com.bap.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.api.model.entity.Products;
import com.bap.api.service.ProductService;

//@CrossOrigin(origins = "http://localhost:8081")
//@Controller + ResponseBODY
@RestController
@RequestMapping("/admin")
/**
 * The ProductController is the class that help admin can manage products
 *
 * @author admin
 *
 */
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping("/products")

    /**
     * This is a method to get all products
     *
     * @return
     */
    public ResponseEntity<List<Products>> getListUser() {
        return new ResponseEntity<>((List<Products>) ProductService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    /**
     * This is a method to get a product by id
     *
     * @param id
     * @return
     */
    public ResponseEntity<Products> getProduct(@PathVariable("id") Long id) {
        Optional<Products> productOptional = ProductService.findById(id);
        return productOptional.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/addPro")
    /**
     * This is a method to add a product
     *
     * @param products
     * @return
     */
    public ResponseEntity<Products> createProduct(@RequestBody Products products) {
        return new ResponseEntity<>(ProductService.save(products), HttpStatus.OK);
    }

    @PutMapping("/editPro/{id}")
    /**
     * This is a method to edit product by id
     *
     * @param id
     * @param products
     * @return
     */
    public ResponseEntity<Products> updateProduct(@PathVariable("id") Long id, @RequestBody Products products) {
        Optional<Products> productOptional = ProductService.findById(id);
        return (ResponseEntity<Products>) productOptional.map(products1 -> {
            products.setId(products1.getId());
            return new ResponseEntity<>(ProductService.save(products), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/deletePro/{id}")
    /**
     * This is a method to delete the product by id
     *
     * @param id
     * @return
     */
    public ResponseEntity<Products> delete(@PathVariable Long id) {
        Optional<Products> productOptional = ProductService.findById(id);
        return productOptional.map(products -> {
            ProductService.remove(id);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

