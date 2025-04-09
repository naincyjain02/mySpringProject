package com.naincy.SpringWebProject.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String imgUrl;
	private String name;
	private String description;
	private double price;
	private int rating;
	
	public Product(String imgUrl,String name,String description,double price,int rating) {
		this.imgUrl=imgUrl;
		this.name=name;
		this.description=description;
		this.price=price;
		this.rating=rating;
		
	}
	public Product() {
		
	}
	
	public Long getId() {
		return id;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl=imgUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating=rating;
	}
	
}
