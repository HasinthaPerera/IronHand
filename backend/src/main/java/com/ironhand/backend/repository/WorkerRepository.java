package com.ironhand.backend.repository;

import com.laborhive.backend.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    // No code needed here! Spring handles the SQL logic.
}