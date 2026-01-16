package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Motorista;
import com.example.backendmenferlog.repositories.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista add(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    public Motorista get(String cpf) {
        return motoristaRepository.findById(cpf).orElse(null);
    }

    public List<Motorista> getAll() {
        return motoristaRepository.findAll();
    }

    public boolean delete(String cpf) {
        Motorista motorista = motoristaRepository.findById(cpf).orElse(null);
        try {
            motoristaRepository.delete(motorista);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
