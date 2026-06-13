package com.ironhand.backend.controller;

import com.ironhand.backend.model.Worker;
import com.ironhand.backend.repository.workerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin(origins = "*") // Allows your HTML file to talk to the backend
public class WorkerController {

    @Autowired
    private workerrepository workerRepository;

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @PostMapping("/{id}/book")
    public Worker bookDate(@PathVariable Long id, @RequestParam("date") String date) {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker not found"));
        String booked = worker.getBookedDates();
        if (booked == null || booked.trim().isEmpty()) {
            booked = date.trim();
        } else {
            List<String> list = new ArrayList<>(Arrays.asList(booked.split(",")));
            if (!list.contains(date.trim())) {
                list.add(date.trim());
                booked = String.join(",", list);
            }
        }
        worker.setBookedDates(booked);
        return workerRepository.save(worker);
    }
}
