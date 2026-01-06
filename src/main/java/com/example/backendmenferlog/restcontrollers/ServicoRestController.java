package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.ServicoDto;
import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/servicos")
public class ServicoRestController {
    @Autowired
    ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Object> getAll () {
        List<Despesa> servicos = servicoService.getAll();
        if(servicos.isEmpty())
            return ResponseEntity.badRequest().body("Não foi possível recuperar servicos!");
        return ResponseEntity.ok(servicos);
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody ServicoDto servicoDto) {
        try {
            Despesa despesa = servicoService.save(servicoDto);
            return ResponseEntity.ok(despesa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível salvar a nova multa: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody ServicoDto servicoDto) {
        try {
            Despesa despesa = servicoService.update(servicoDto);
            return ResponseEntity.ok(despesa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível alterar a multa: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        try {
            boolean deleted = servicoService.delete(id);
            if (deleted)
                return ResponseEntity.ok(Map.of("message", "Serviço deletado com sucesso!"));
            else
                return ResponseEntity.badRequest().body("Não foi possível deletar o serviço!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível deletar o serviço: " + e.getMessage());
        }
    }
}
