package com.naincy.SpringWebProject.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="app_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
  
   private String email;
   private long contactn;
   private String password;
   public User() {
	   
   }
   public User(long contactn) {
	   this.contactn=contactn;
   }
   public User(String password) {
	   this.password=password;
   }
   public User(long contactn,String password) {
	   this.contactn=contactn;
	   this.password=password;
   }
   public User(String email,long contactn,String password) {
	   this.email=email;
	   this.contactn=contactn;
	   this.password=password;
   }
   
   public Long getId() {
	   return id;
   }
   
   public String getEmail() {
	   return email;
   }
   public void setEmail(String email) {
	   this.email=email;
   }
   public long getContact() {
	   return contactn;
   }
   public void setContact(long contactn) {
	   this.contactn=contactn;
   }
   public String getPassword() {
	   return password;
   }
   public void setPassword(String password) {
	   this.password=password;
   }
  
  
}
