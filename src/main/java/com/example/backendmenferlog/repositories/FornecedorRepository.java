package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
}
