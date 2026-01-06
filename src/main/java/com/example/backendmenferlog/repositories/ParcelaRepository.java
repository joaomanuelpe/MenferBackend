package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
    @Query("SELECT p FROM Parcela p WHERE p.gasto.idGasto = :idGasto")
    List<Parcela> findByGastoId(@Param("idGasto") Long idGasto);
}
