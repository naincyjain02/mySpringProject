package com.naincy.SpringWebProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naincy.SpringWebProject.model.Product;
import com.naincy.SpringWebProject.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	 @PostMapping("/product")
	    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
	        Product newProduct = productService.saveProduct(product);
	        return ResponseEntity.ok(newProduct);
	    }

	 
	    @GetMapping("/products")
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	
	    @GetMapping("/products/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Optional<Product> product = productService.getProductById(id);
	        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	
	    @PutMapping("/products/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        Product updatedProduct = productService.updateProduct(id, product);
	        return ResponseEntity.ok(updatedProduct);
	    }

	
	    @DeleteMapping("/products/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.ok("Product deleted successfully");
	    }
}
