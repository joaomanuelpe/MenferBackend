package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Fornecedor;
import com.example.backendmenferlog.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor add (Fornecedor fornecedor) {
        Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
        return novoFornecedor;
    }

    public Fornecedor get (String cnpj) {
        Fornecedor fornecedor = fornecedorRepository.findById(cnpj).orElse(null);
        return fornecedor;
    }

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public boolean delete(String cnpj) {
        Fornecedor fornecedor = fornecedorRepository.findById(cnpj).orElse(null);
        try {
            fornecedorRepository.delete(fornecedor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
