package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.AbastecimentoDTO;
import com.example.backendmenferlog.dto.AbastecimentoResponseDTO;
import com.example.backendmenferlog.entities.Cliente;
import com.example.backendmenferlog.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        if (!clientes.isEmpty())
            return ResponseEntity.ok(clientes);
        return ResponseEntity.badRequest().body("Não há nenhum cliente!");
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Object> get(@PathVariable String cnpj) {
        Cliente cliente = clienteService.get(cnpj);
        if (cliente != null)
            return ResponseEntity.ok(cliente);
        return ResponseEntity.badRequest().body("Erro ao recuperar cliente!");
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.add(cliente);  
        if (novoCliente != null)
            return ResponseEntity.ok(novoCliente);
        return ResponseEntity.badRequest().body("Erro ao inserir cliente!");
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Cliente cliente) {
        try {
            Cliente cliente1 = clienteService.add(cliente);
            return ResponseEntity.ok().body(Map.of("message", "Cliente alterado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar cliente!");
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam String cnpj) {
        boolean flag = clienteService.delete(cnpj);
        if (flag)
            return ResponseEntity.ok("Cliente excluído com sucesso!");
        return ResponseEntity.badRequest().body("Erro ao excluir cliente!");
    }
}
