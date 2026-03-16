package com.ironhand.backend.repository;

import com.ironhand.backend.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface userrepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);
}