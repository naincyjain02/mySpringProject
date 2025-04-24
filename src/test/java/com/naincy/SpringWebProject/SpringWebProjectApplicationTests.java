package com.naincy.SpringWebProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.naincy.SpringWebProject.model.Product;
import com.naincy.SpringWebProject.repository.ProductRepo;

@SpringBootTest
class SpringWebProjectApplicationTests {

	@Autowired
	ProductRepo repo;
	
	@Test
	void testCreate() {
Product p=new Product();
		
		p.setImgUrl("https://tse1.mm.bing.net/th?id=OIP.mL3uxbU9qNGyM2rFL7lsFwHaEH&pid=Api&P=0&h=180");
		p.setName("Maven");
		p.setDescription("good");
		p.setPrice(400.0);
		p.setRating(3);
		Product savedProduct=repo.save(p);
		assertNotNull(savedProduct.getId());
		assertEquals("Maven",savedProduct.getName());
		assertEquals("https://tse1.mm.bing.net/th?id=OIP.mL3uxbU9qNGyM2rFL7lsFwHaEH&pid=Api&P=0&h=180",savedProduct.getImgUrl());
		assertEquals("good",savedProduct.getDescription());
		assertEquals(400.0,savedProduct.getPrice());
		assertEquals(3,savedProduct.getRating());
	}
	
	@Test
	public void testGetAllProducts() {
		List<Product> list=repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void testGetProductById() {
Product p=new Product();
		
		p.setImgUrl("https://tse1.mm.bing.net/th?id=OIP.mL3uxbU9qNGyM2rFL7lsFwHaEH&pid=Api&P=0&h=180");
		p.setName("bag");
		p.setDescription("good");
		p.setPrice(200.0);
		p.setRating(3);
		Product savedProduct=repo.save(p);
		Product product=repo.findById(savedProduct.getId()).get();
		assertEquals("bag",product.getName());
		
	}
	

}
