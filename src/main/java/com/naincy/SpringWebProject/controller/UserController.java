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

import com.naincy.SpringWebProject.model.User;
import com.naincy.SpringWebProject.service.UserService;

@RestController
public class UserController {
 
	@Autowired
	UserService service;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
	 return ResponseEntity.ok(service.addUser(user));
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return service.getAllUsers();
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		Optional<User> user=service.getUserById(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updatedUser(@PathVariable Long id,@RequestBody User user){
		 
		
			User u=service.updateUser(id, user);
			return ResponseEntity.ok(u);
	
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		service.deleteUser(id);
		return ResponseEntity.ok("User Deleted Successfully!");
	}
	
	
	
	
	
}
