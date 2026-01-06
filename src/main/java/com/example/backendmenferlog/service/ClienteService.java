package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Cliente;
import com.example.backendmenferlog.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente add(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente get(String cnpj) {
        return clienteRepository.findById(cnpj).orElse(null);
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public boolean delete(String cnpj) {
        Cliente cliente = clienteRepository.findById(cnpj).orElse(null);
        try {
            clienteRepository.delete(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
