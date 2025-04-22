package com.naincy.SpringWebProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naincy.SpringWebProject.model.Product;
import com.naincy.SpringWebProject.repository.ProductRepo;
import com.naincy.SpringWebProject.exception.ProductNotFoundException;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public Product saveProduct(Product product) {
        try {
            return repo.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving product: " + e.getMessage(), e);
        }
    }

    public List<Product> getAllProducts() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching all products: " + e.getMessage(), e);
        }
    }

    public Optional<Product> getProductById(Long id) {
        try {
            return repo.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching product by ID: " + e.getMessage(), e);
        }
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        try {
            Optional<Product> existingProduct = repo.findById(id);
            if (existingProduct.isPresent()) {
                Product product = existingProduct.get();
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setDescription(updatedProduct.getDescription());
                return repo.save(product);
            } else {
                throw new ProductNotFoundException("Product with ID " + id + " not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while updating product: " + e.getMessage(), e);
        }
    }

    public void deleteProduct(Long id) {
        try {
            if (!repo.existsById(id)) {
                throw new ProductNotFoundException("Product with ID " + id + " not found");
            }
            repo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting product: " + e.getMessage(), e);
        }
    }
}
