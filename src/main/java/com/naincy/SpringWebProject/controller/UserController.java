package com.naincy.SpringWebProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naincy.SpringWebProject.model.User;
import com.naincy.SpringWebProject.service.UserService;

@RestController
public class UserController {
 
	@Autowired
	UserService service;
	
	@RequestMapping("/")
	public void getUsers() {
	 service.addUser(new User("naincy123@gmail.com",9893084451L,"naincy#123"));
	}
}
