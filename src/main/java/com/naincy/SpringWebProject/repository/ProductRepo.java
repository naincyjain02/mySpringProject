package com.naincy.SpringWebProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naincy.SpringWebProject.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
