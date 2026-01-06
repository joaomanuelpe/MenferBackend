package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
