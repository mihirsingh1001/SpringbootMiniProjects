package com.project.usermodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.usermodule.dtos.LoginDto;
import com.project.usermodule.dtos.UserDto;
import com.project.usermodule.services.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User user;

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto) {
        UserDto registerUser = user.registerUser(userdto);
        return new ResponseEntity<UserDto>(registerUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Boolean> isLoginUser(@RequestBody LoginDto loginDto) {
        boolean isLoginUser = user.isLoginUser(loginDto);
        return new ResponseEntity<Boolean>(isLoginUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> allUserDetail(){
        List<UserDto> allUsers = user.allUsers();
        return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.OK);
    }
}
