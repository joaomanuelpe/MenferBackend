package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
