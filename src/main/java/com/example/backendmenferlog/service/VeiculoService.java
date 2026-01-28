package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Veiculo;
import com.example.backendmenferlog.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo save(Veiculo veiculo) {

        if (veiculoRepository.existsById(veiculo.getPlaca())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Já existe um veículo cadastrado com essa placa"
            );
        }

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

    public void delete(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Veículo não encontrado"
                ));

        try {
            veiculoRepository.delete(veiculo);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Não é possível excluir o veículo porque existem multas associadas a ele"
            );
        }
    }

    public void update(Veiculo veiculo) throws IOException {
        veiculoRepository.save(veiculo);
    }

}
