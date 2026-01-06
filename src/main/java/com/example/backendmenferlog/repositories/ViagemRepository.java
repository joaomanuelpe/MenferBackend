package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    List<Viagem> findByMotoristaOrderByEmpresa(String cpf);

    List<Viagem> findAllByOrderByEmpresa();
}
