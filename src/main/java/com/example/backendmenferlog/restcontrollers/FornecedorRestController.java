package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.entities.Fornecedor;
import com.example.backendmenferlog.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/fornecedor")
public class FornecedorRestController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Fornecedor> fornecedorList = fornecedorService.getAll();
        if (!fornecedorList.isEmpty())
            return ResponseEntity.ok(fornecedorList);
        return ResponseEntity.badRequest().body("Não há nenhum fornecedor!");
    }

    @GetMapping(value = "/{cnpj}")
    public ResponseEntity<Object> get (@PathVariable(name = "cnpj") String cnpj) {
        Fornecedor fornecedor = fornecedorService.get(cnpj);
        if (fornecedor != null)
            return ResponseEntity.ok(fornecedor);
        return ResponseEntity.badRequest().body("Erro ao recuperar fornecedor");
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Fornecedor fornecedor) {
        Fornecedor forncedor2 = fornecedorService.add(fornecedor);
        if (forncedor2 != null)
            return ResponseEntity.ok(forncedor2);
        return ResponseEntity.badRequest().body("Erro ao inserir fornecedor");
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Fornecedor fornecedor) {
        try {
            Fornecedor fornecedor1 = fornecedorService.add(fornecedor);
            return ResponseEntity.ok().body(Map.of("message", "Fornecedor alterado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar fornecedor!");
        }
    }

    @DeleteMapping(value = "/{cnpj}")
    public ResponseEntity<Object> delete (@PathVariable(name = "cnpj") String cnpj) {
        boolean flag = fornecedorService.delete(cnpj);
        if (flag)
            return ResponseEntity.ok("Fornecedor excluído com sucesso!");
        return ResponseEntity.badRequest().body("Erro ao excluir fornecedor!");
    }
}
