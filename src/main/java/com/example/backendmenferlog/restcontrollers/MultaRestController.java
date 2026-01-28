package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.MultaDto;
import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.service.DespesaService;
import com.example.backendmenferlog.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/multa")
public class MultaRestController {
    @Autowired
    MultaService multaService;
    @Autowired
    DespesaService despesaService;

    @GetMapping
    public ResponseEntity<Object> getAll () {
        List<Despesa> multas = multaService.getAll();
        if(multas.isEmpty())
            return ResponseEntity.badRequest().body("Não foi possível recuperar multas!");
        return ResponseEntity.ok(multas);
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody MultaDto multaDto) throws IOException {
        Despesa despesa = multaService.save(multaDto);
        return ResponseEntity.ok(despesa);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody MultaDto multaDto) {
        try {
            Despesa despesa = multaService.update(multaDto);
            return ResponseEntity.ok(despesa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível alterar a multa: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        if(multaService.delete(id))
            return ResponseEntity.ok(Map.of("message", "Multa deletado com sucesso!"));
        return ResponseEntity.badRequest().body("Erro ao deletar multa.");
    }
}
