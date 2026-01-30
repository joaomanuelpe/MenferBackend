package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Acesso;
import com.example.backendmenferlog.exception.BusinessException;
import com.example.backendmenferlog.repositories.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessoService {
    @Autowired
    private AcessoRepository acessoRepository;

    public List<Acesso> getAll() {
        return acessoRepository.findAll();
    }

    private void validarAcesso (Long id, Acesso acesso) {
        if (acesso.getTipo() == null || acesso.getTipo().isBlank())
            throw new BusinessException("O tipo de acesso é obrigatório");

        if(!acesso.isCardDocumento() && !acesso.isCardAbastecimento() && !acesso.isCardCadastro() && !acesso.isCardFechamento() && !acesso.isCardFinanceiro() && !acesso.isCardViagem())
            throw new BusinessException("O tipo de acesso deve permitir pelo menos um acesso a cards");

        if(acessoRepository.existsBySameCards(id, acesso))
            throw new BusinessException("Já há um tipo de acesso com acesso aos mesmos cards");
    }

    public Acesso add(Acesso acesso) {
        validarAcesso(null, acesso);
        return acessoRepository.save(acesso);
    }

    public Acesso update(Long id, Acesso acesso) {
        validarAcesso(id, acesso);
        acesso.setIdAcesso(id);
        return acessoRepository.save(acesso);
    }

    public void delete(Long id) {
        Acesso acesso = acessoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Acesso não encontrado para a exclusão"));

        if ("ADM".equalsIgnoreCase(acesso.getTipo()))
            throw new BusinessException("O tipo de acesso ADM não pode ser removido");

        acessoRepository.delete(acesso);
    }
}
