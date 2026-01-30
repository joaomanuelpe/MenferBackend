package com.example.backendmenferlog.repositories;

import com.example.backendmenferlog.entities.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    @Query("""
    SELECT COUNT(a) > 0
    FROM Acesso a
    WHERE (:id IS NULL OR a.idAcesso <> :id)
      AND a.cardDocumento = :#{#acesso.isCardDocumento()}
      AND a.cardAbastecimento = :#{#acesso.isCardAbastecimento()}
      AND a.cardCadastro = :#{#acesso.isCardCadastro()}
      AND a.cardFechamento = :#{#acesso.isCardFechamento()}
      AND a.cardFinanceiro = :#{#acesso.isCardFinanceiro()}
      AND a.cardViagem = :#{#acesso.isCardViagem()}
""")
    boolean existsBySameCards(
            @Param("id") Long id,
            @Param("acesso") Acesso acesso
    );
}
