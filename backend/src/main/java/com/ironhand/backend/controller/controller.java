package com.ironhand.backend.controller;

import com.ironhand.backend.model.Worker;
import com.ironhand.backend.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin(origins = "*") // Allows your HTML file to talk to the backend
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }
}