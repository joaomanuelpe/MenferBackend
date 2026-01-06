package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.ComissaoMotorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComissaoMotoristaRepository extends JpaRepository<ComissaoMotorista, Long> {

    List<ComissaoMotorista> findByIdDaViagemOrderByIdComissaoDesc(Long idDaViagem);

    @Query("SELECT c FROM ComissaoMotorista c WHERE c.idDaViagem IN " +
            "(SELECT v.idViagem FROM Viagem v WHERE v.motorista = :motorista) " +
            "ORDER BY c.idComissao DESC")
    List<ComissaoMotorista> findByMotoristaOrderByIdComissaoDesc(@Param("motorista") String motorista);

    @Query("SELECT c FROM ComissaoMotorista c WHERE " +
            "(:idDaViagem IS NULL OR c.idDaViagem = :idDaViagem) AND " +
            "(:motorista IS NULL OR c.idDaViagem IN " +
            "(SELECT v.idViagem FROM Viagem v WHERE v.motorista = :motorista))")
    List<ComissaoMotorista> findForEstatisticas(@Param("idDaViagem") Long idDaViagem,
                                                @Param("motorista") String motorista);

    List<ComissaoMotorista> findAllByOrderByIdComissaoDesc();
}