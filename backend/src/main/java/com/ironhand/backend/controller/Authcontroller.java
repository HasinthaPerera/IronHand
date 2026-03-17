package com.ironhand.backend.controller;

import com.ironhand.backend.model.user;
import com.ironhand.backend.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class Authcontroller {

    @Autowired
    private userrepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody user loginRequest) {
        Optional<user> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
        
    }
}