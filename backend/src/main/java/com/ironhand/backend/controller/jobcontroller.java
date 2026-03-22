package com.ironhand.backend.controller;

import com.ironhand.backend.model.job;
import com.ironhand.backend.repository.jobrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class jobcontroller {

    @Autowired
    private jobrepository jobRepository;

    @PostMapping("/post")
    public ResponseEntity<?> postJob(@RequestBody job jobData) {
        // This will print the title in your IntelliJ console to prove it's not NULL anymore
        System.out.println("Received Job: " + jobData.getTitle());

        jobRepository.save(jobData);
        return ResponseEntity.ok("Job posted successfully!");
    }
}