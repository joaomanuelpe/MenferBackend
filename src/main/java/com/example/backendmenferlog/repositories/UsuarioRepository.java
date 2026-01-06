package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
