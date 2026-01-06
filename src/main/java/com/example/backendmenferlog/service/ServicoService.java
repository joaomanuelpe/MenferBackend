package com.example.backendmenferlog.service;

import com.example.backendmenferlog.dto.ServicoDto;
import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.entities.Servico;
import com.example.backendmenferlog.repositories.DespesaRepository;
import com.example.backendmenferlog.repositories.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    DespesaRepository despesaRepository;
    @Autowired
    private ServicoRepository servicoRepository;

    public List<Despesa> getAll() {
        return despesaRepository.findAllByServico();
    }

    public Despesa save(ServicoDto servicoDto) {
        Servico novoServico = new Servico(servicoDto.getServico().getIdServico(), servicoDto.getServico().getVeiculo(), servicoDto.getServico().getOrdemServico());
        System.out.println(servicoDto.getServico().getVeiculo());
        servicoRepository.save(novoServico);
        Despesa novaDespesa = new Despesa(servicoDto.getIdDepesa(), servicoDto.getDataDespesa(), servicoDto.getDataVencimento(), servicoDto.getValor(), novoServico, "Pendente", servicoDto.getDescricao());
        return despesaRepository.save(novaDespesa);
    }

    @Transactional
    public Despesa update(ServicoDto servicoDto) {
        Servico servicoExistente = servicoRepository.findById(servicoDto.getServico().getIdServico())
                .orElse(null);

        servicoExistente.setVeiculo(servicoDto.getServico().getVeiculo());
        servicoExistente.setOrdemServico(servicoDto.getServico().getOrdemServico());
        servicoRepository.save(servicoExistente);

        Despesa despesaExistente = despesaRepository.findByServicoId(servicoExistente.getIdServico());
        if (despesaExistente == null)
            throw new RuntimeException("Despesa não encontrada para esse serviço");
        despesaExistente.setDataDespesa(servicoDto.getDataDespesa());
        despesaExistente.setDataVencimento(servicoDto.getDataVencimento());
        despesaExistente.setValor(servicoDto.getValor());
        despesaExistente.setDescricao(servicoDto.getDescricao());
        if (servicoDto.getDataPagamento() != null) {
            despesaExistente.setDataPagamento(servicoDto.getDataPagamento());
            despesaExistente.setStatus("QUITADO");
        } else {
            despesaExistente.setStatus("PENDENTE");
        }
        return despesaRepository.save(despesaExistente);
    }

    @Transactional
    public boolean delete(Long id) {
        Despesa despesa = despesaRepository.findByServicoId(id);
        System.out.println(despesa);
        if (despesa == null)
            return false;
        despesaRepository.delete(despesa);
        return true;
    }
}
