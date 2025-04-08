package com.naincy.SpringWebProject.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naincy.SpringWebProject.model.User;
import com.naincy.SpringWebProject.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	
	
   public void addUser(User user){
	   
	   repo.save(user); 
	   
   }


}
