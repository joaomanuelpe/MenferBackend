package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Cliente;
import com.example.backendmenferlog.entities.Veiculo;
import com.example.backendmenferlog.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo save (Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo get(String placa) {
        return veiculoRepository.findById(placa).orElse(null);
    }

    public List<Veiculo> getAll() {
        return veiculoRepository.findAll();
    }

    public List<Veiculo> getAllCavalos() {
        return getAll().stream()
                .filter(v -> "cavalo".equalsIgnoreCase(v.getTipo()))
                .collect(Collectors.toList());
    }

    public List<Veiculo> getAllReboques () {
        return getAll().stream()
                .filter(v -> "reboque".equalsIgnoreCase(v.getTipo()))
                .collect(Collectors.toList());
    }

    public boolean delete(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa).orElse(null);
        try {
            veiculoRepository.delete(veiculo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
