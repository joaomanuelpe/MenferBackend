package com.example.backendmenferlog.service;

import com.example.backendmenferlog.dto.MultaDto;
import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.entities.Multa;
import com.example.backendmenferlog.repositories.DespesaRepository;
import com.example.backendmenferlog.repositories.MultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultaService {
    @Autowired
    MultaRepository multaRepository;
    @Autowired
    DespesaRepository despesaRepository;

    @Transactional
    public Despesa save (MultaDto multaDto) {
        Multa novaMulta = new Multa(multaDto.getMulta().getIdMulta(), multaDto.getMulta().getMotorista(), multaDto.getMulta().getVeiculo(), multaDto.getMulta().getNumAutoInfracao(), multaDto.getMulta().getOrgaoAutuador());
        multaRepository.save(novaMulta);
        Despesa novaDespesa = new Despesa(multaDto.getIdDepesa(), multaDto.getDataDespesa(), multaDto.getDataVencimento(), multaDto.getValor(), novaMulta, "Pendente", multaDto.getDescricao());
        return despesaRepository.save(novaDespesa);
    }

    @Transactional
    public Despesa update (MultaDto multaDto) {
        Multa multaExistente = multaRepository.findById(multaDto.getMulta().getIdMulta())
                .orElse(null);

        multaExistente.setMotorista(multaDto.getMulta().getMotorista());
        multaExistente.setVeiculo(multaDto.getMulta().getVeiculo());
        multaExistente.setNumAutoInfracao(multaDto.getMulta().getNumAutoInfracao());
        multaExistente.setOrgaoAutuador(multaDto.getMulta().getOrgaoAutuador());
        multaRepository.save(multaExistente);

        Despesa despesaExistente = despesaRepository.findByMultaId(multaExistente.getIdMulta());
        if (despesaExistente == null)
            throw new RuntimeException("Despesa não encontrada para essa multa");


        despesaExistente.setDataPagamento(multaDto.getDataPagamento());
        despesaExistente.setDataDespesa(multaDto.getDataDespesa());
        despesaExistente.setDataVencimento(multaDto.getDataVencimento());
        despesaExistente.setValor(multaDto.getValor());
        despesaExistente.setDescricao(multaDto.getDescricao());
        if(multaDto.getDataPagamento() != null)
            despesaExistente.setStatus("QUITADO");
        else
            despesaExistente.setStatus("Pendente");

        return despesaRepository.save(despesaExistente);
    }

    public List<Despesa> getAll () {
        return despesaRepository.findAllByMulta();
    }

    @Transactional
    public boolean delete(Long id) {
        Despesa despesa = despesaRepository.findByMultaId(id);
        System.out.println(despesa);
        if (despesa == null)
            return false;
        despesaRepository.delete(despesa);
        return true;
    }
}
