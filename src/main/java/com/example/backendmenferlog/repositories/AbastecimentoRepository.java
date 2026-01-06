package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {

    List<Abastecimento> findByPlacaOrderByDataDesc(String placa);

    List<Abastecimento> findByDataBetweenOrderByDataDesc(LocalDate dataInicial, LocalDate dataFinal);

    @Query("SELECT a FROM Abastecimento a WHERE " +
            "(:placa IS NULL OR a.placa = :placa) AND " +
            "(:dataInicial IS NULL OR :dataFinal IS NULL OR a.data BETWEEN :dataInicial AND :dataFinal)")
    List<Abastecimento> findForEstatisticas(@Param("placa") String placa,
                                            @Param("dataInicial") LocalDate dataInicial,
                                            @Param("dataFinal") LocalDate dataFinal);

    List<Abastecimento> findAllByOrderByDataDesc();
}
