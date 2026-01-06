package com.example.backendmenferlog.service;

import com.example.backendmenferlog.dto.ParcelaDto;
import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.entities.Gasto;
import com.example.backendmenferlog.entities.Parcela;
import com.example.backendmenferlog.repositories.DespesaRepository;
import com.example.backendmenferlog.repositories.GastoRepository;
import com.example.backendmenferlog.repositories.ParcelaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParcelaService {
    @Autowired
    private ParcelaRepository parcelaRepository;
    @Autowired
    private GastoRepository gastoRepository;
    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> getAll () {
        return despesaRepository.findAllByParcela();
    }

    @Transactional
    public List<Despesa> save (ParcelaDto parcelaDto) {
        double valorParc = parcelaDto.getValor() / parcelaDto.getParcela().getGasto().getQtdParc();
        List<Despesa> parcelas = new ArrayList<>();
        Gasto gasto = new Gasto(parcelaDto.getParcela().getGasto().getIdGasto(), parcelaDto.getParcela().getGasto().getFornecedor(), parcelaDto.getParcela().getGasto().getNumNotaFisc(), parcelaDto.getParcela().getGasto().getNumBoleto(), parcelaDto.getParcela().getGasto().getQtdParc());
        gastoRepository.save(gasto);
        for (int i = 0; i < parcelaDto.getParcela().getGasto().getQtdParc(); i++) {
            Parcela parcela = new Parcela(parcelaDto.getParcela().getIdParcela(), i + 1, gasto);
            parcelaRepository.save(parcela);
            LocalDate vencimento = parcelaDto.getDataVencimento().plusMonths(i);
            Despesa despesa = new Despesa(parcelaDto.getIdDespesa(), parcelaDto.getDataDespesa(), vencimento, valorParc, parcela, "Pendente", parcelaDto.getDescricao());
            despesaRepository.save(despesa);
            parcelas.add(despesa);
        }
        return parcelas;
    }

    @Transactional
    public Despesa update(ParcelaDto parcelaDto) {
        Despesa despesa = despesaRepository.findById(parcelaDto.getIdDespesa()).orElse(null);
        if (despesa != null) {
            despesa.setStatus("QUITADO");
            despesa.setDataPagamento(parcelaDto.getDataPagamento());
        }
        return despesa;
    }

    @Transactional
    public Despesa updateGasto(Gasto novoGasto) {
        Gasto gastoExistente = gastoRepository.findById(novoGasto.getIdGasto()).orElse(null);
        if (gastoExistente != null) {
            gastoRepository.save(novoGasto);
        }
        return null;
    }

    @Transactional
    public boolean delete(Long id) {
        try {
            List<Despesa> despesas = despesaRepository.findAllByGastoId(id);
            despesaRepository.deleteAll(despesas);

            List<Parcela> parcelas = parcelaRepository.findByGastoId(id);
            parcelaRepository.deleteAll(parcelas);

            Gasto gasto = gastoRepository.findById(id).orElse(null);
            gastoRepository.delete(gasto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
