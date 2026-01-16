package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.ClienteDTO;
import com.example.backendmenferlog.entities.Cliente;
import com.example.backendmenferlog.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        if (!clientes.isEmpty()) {
            List<ClienteDTO> dtoList = clientes.stream()
                    .map(ClienteDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
        return ResponseEntity.badRequest().body("Não há nenhum cliente!");
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Object> get(@PathVariable String cnpj) {
        Cliente cliente = clienteService.get(cnpj);
        if (cliente != null)
            return ResponseEntity.ok(new ClienteDTO(cliente));
        return ResponseEntity.badRequest().body("Erro ao recuperar cliente!");
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.add(cliente);
        if (novoCliente != null)
            return ResponseEntity.ok(new ClienteDTO(novoCliente));
        return ResponseEntity.badRequest().body("Erro ao inserir cliente!");
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<Object> update(@PathVariable String cnpj, @RequestBody Cliente cliente) {
        try {
            Cliente clienteExistente = clienteService.get(cnpj);
            if (clienteExistente != null) {
                cliente.setCnpj(cnpj);
                Cliente clienteAtualizado = clienteService.add(cliente);
                return ResponseEntity.ok(new ClienteDTO(clienteAtualizado));
            }
            return ResponseEntity.badRequest().body("Cliente não encontrado!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar cliente!");
        }
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Object> delete(@PathVariable String cnpj) {
        boolean flag = clienteService.delete(cnpj);
        if (flag)
            return ResponseEntity.ok("Cliente excluído com sucesso!");
        return ResponseEntity.badRequest().body("Erro ao excluir cliente!");
    }
}
