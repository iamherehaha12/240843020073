package com.knowit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.knowit.entities.User;
import com.knowit.entities.UserLogin;
import com.knowit.services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userSer;

    @GetMapping("/getalluser")
    public List<User> getallusers() {
        return userSer.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLogin userLogin) {
        User user = userSer.loginUser(userLogin.getEmail(), userLogin.getPassword());
        
        if (user == null) {
            // Check if the user exists (invalid email) or if password is incorrect
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }

        // If login is successful, return the user object or some relevant data
        return ResponseEntity.ok(user);
    }

    @PutMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userSer.saveUser(user);
    }
}
