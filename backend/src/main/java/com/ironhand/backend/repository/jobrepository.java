package com.ironhand.backend.repository;

import com.ironhand.backend.model.job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jobrepository extends JpaRepository<job, Long> {
}