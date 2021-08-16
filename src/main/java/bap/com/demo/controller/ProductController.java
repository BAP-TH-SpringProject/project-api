package bap.com.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import bap.com.demo.model.Products;
import bap.com.demo.service.ProductService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
//@Controller + ResponseBODY
//@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService ProductService;
	//Get List Data
		@GetMapping("/")

		public ResponseEntity<List<Products>> getListUser() {
			return new ResponseEntity<>((List<Products>) ProductService.findAll(), HttpStatus.OK);
		}

		// Get product by id
		@GetMapping("/product/{id}")
		public ResponseEntity<Products> getProduct(@PathVariable("id") Long id) {
			// @PathVariable lay ra thông tin trong URL
			Optional<Products> productOptional = ProductService.findById(id);
			return productOptional.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

		}

		// Create product
		@PostMapping("/new")

		public ResponseEntity<Products> createProduct(@RequestBody Products products) {
	        return new ResponseEntity<>(ProductService.save(products), HttpStatus.OK);
		}

		// Update product by Id
		@PutMapping("/edit/{id}")

		public ResponseEntity<Products> updateProduct(@PathVariable("id") Long id,
				@RequestBody Products products) {
			Optional<Products> productOptional = ProductService.findById(id);
			return (ResponseEntity<Products>) productOptional.map(products1 -> {
				products.setId_product(products1.getId_product());
				return new ResponseEntity<>(ProductService.save(products), HttpStatus.OK);
			}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

		}

		// Delete product
		@DeleteMapping("/delete/{id}")

		public ResponseEntity<Products> delete(@PathVariable Long id) {
			Optional<Products> productOptional = ProductService.findById(id);
			  return productOptional.map(products -> {
					ProductService.remove(id);
		            return new ResponseEntity<>(products, HttpStatus.OK);
		        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}

}
