package com.naincy.SpringWebProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naincy.SpringWebProject.model.auth;
import com.naincy.SpringWebProject.security.JWTUtil;
import com.naincy.SpringWebProject.security.MyUserDetailsService;

@RestController

public class AuthController {

	
	@Autowired
     AuthenticationManager authenticationManager;
     @Autowired
     JWTUtil jwtService;
     
     @Autowired
 MyUserDetailsService userDetailsService;



    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody auth request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String jwt = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }
}

