package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, String> {
    Motorista findByName(String name);
}
