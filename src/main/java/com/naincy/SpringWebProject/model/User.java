package com.naincy.SpringWebProject.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="app_user")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

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

   public void setPassword(String password) {
	   this.password=password;
   }
   @Override
   public boolean isAccountNonExpired() {
       return true;
   }

   @Override
   public boolean isAccountNonLocked() {
       return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
       return true;
   }

   @Override
   public boolean isEnabled() {
       return true;
   }
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(); 
   }

   @Override
   public String getPassword() {
       return password;
   }

   @Override
   public String getUsername() {
       return email; 
   }

  
  
}
