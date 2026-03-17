package com.ironhand.backend.controller;

import com.ironhand.backend.model.user;
import com.ironhand.backend.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Allows your HTML files to talk to this Java server
public class Authcontroller {

    @Autowired
    private userrepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody user loginRequest) {
        // Find user by email using the repository
        Optional<user> user = userRepository.findByEmail(loginRequest.getEmail());

        // Check if user exists and password matches
        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody user newUser) {
        // Check if the email is already registered
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use!");
        }

        // Save the new user to the MySQL database
        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }
}