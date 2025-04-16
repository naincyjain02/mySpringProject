package com.naincy.SpringWebProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.naincy.SpringWebProject.model.User;
import com.naincy.SpringWebProject.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
   public User addUser(User user){
	   user.setPassword(encoder.encode(user.getPassword()));
	  return repo.save(user); 
	   
   }
   
   public List<User> getAllUsers(){
	   return repo.findAll() ;
	   }
   public Optional<User> getUserById(Long id){
	   Optional<User>u=repo.findById(id);
	   return u;
   }
   
   public User updateUser(Long id,User user){
	   Optional<User> existingUser=repo.findById(id);
	   
	   if(existingUser.isPresent()) {
		   
		   if(user.getContact()!=0) {
			   if(user.getPassword()!=null) {
				   existingUser.get().setContact(user.getContact());
				   existingUser.get().setPassword(user.getPassword());
			   }
			   else {
				   existingUser.get().setContact(user.getContact());
			   }
		   }
		   else {
			   existingUser.get().setPassword(user.getPassword());
		   }
		   
			  return repo.save(existingUser.get());
	   }
	   else
	   {
		    throw new RuntimeException("User not found"); 
	   }
   }
   
   public void deleteUser(Long id) {
	    repo.deleteById(id);
   }


}
