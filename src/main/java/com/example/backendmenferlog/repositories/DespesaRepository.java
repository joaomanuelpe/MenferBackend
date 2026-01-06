package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    @Query("SELECT d FROM Despesa d JOIN d.multa m")
    List<Despesa> findAllByMulta();

    @Query("SELECT d FROM Despesa d JOIN d.parcela p")
    List<Despesa> findAllByParcela();

    @Query("SELECT d FROM Despesa d JOIN d.servico s")
    List<Despesa> findAllByServico();

    @Query("SELECT d FROM Despesa d WHERE d.multa.idMulta = :idMulta")
    Despesa findByMultaId(@Param("idMulta") Long idMulta);

    @Query("SELECT d FROM Despesa d WHERE d.servico.idServico = :idServico")
    Despesa findByServicoId(@Param("idServico") Long idServico);

    @Query("SELECT d FROM Despesa d WHERE d.parcela.gasto.idGasto = :idGasto")
    List<Despesa> findAllByGastoId(@Param("idGasto") Long idGasto);

    @Query("SELECT d FROM Despesa d WHERE d.abastecimento.idAbastecimento = :idAbastecimento")
    Despesa findByAbastecimentoId(@Param("idAbastecimento") Long idAbastecimento);
}
