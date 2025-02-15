package com.project.usermodule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.usermodule.dtos.JwtRequest;
import com.project.usermodule.dtos.JwtResponse;
import com.project.usermodule.jwt.JwtUtility;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping("/generate-token")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

        String token = jwtUtility.generateToken(jwtRequest.getUsername());
        return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.CREATED);
        
    }
}
