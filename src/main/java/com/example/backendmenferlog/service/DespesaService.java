package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {
    @Autowired
    DespesaRepository despesaRepository;

    public Despesa save (Despesa despesa) {
        return despesaRepository.save(despesa);
    }
}
