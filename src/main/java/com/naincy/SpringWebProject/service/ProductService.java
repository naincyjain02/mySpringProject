package com.naincy.SpringWebProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.naincy.SpringWebProject.model.Product;
import com.naincy.SpringWebProject.repository.ProductRepo;


@Service
public class ProductService {

	@Autowired
	ProductRepo repo;
	
	  public Product saveProduct(Product product) {
	        return repo.save(product);
	    }

	  
	    public List<Product> getAllProducts() {
	        return repo.findAll();
	    }

	    public Optional<Product> getProductById(Long id) {
	        return repo.findById(id);
	    }

	   
	    public Product updateProduct(Long id, Product updatedProduct) {
	        Optional<Product> existingProduct = repo.findById(id);
	        if (existingProduct.isPresent()) {
	            Product product = existingProduct.get();
	            product.setName(updatedProduct.getName());
	            product.setPrice(updatedProduct.getPrice());
	            product.setDescription(updatedProduct.getDescription());
	            return repo.save(product);
	        } else {
	            throw new RuntimeException("Product not found");
	        }
	    }

	 
	    public void deleteProduct(Long id) {
	        repo.deleteById(id);
	    }
	
}
