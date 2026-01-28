package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.ParcelaDto;
import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.entities.Gasto;
import com.example.backendmenferlog.service.ParcelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/parcela")
public class ParcelaRestController {
    @Autowired
    private ParcelaService parcelaService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Despesa> gastos = parcelaService.getAll();
        if (gastos.isEmpty())
            return ResponseEntity.badRequest().body("Não foram encontrados gastos.");
        return ResponseEntity.ok(gastos);
    }

    @PostMapping
    public ResponseEntity<List<Despesa>> save(@RequestBody ParcelaDto parcelaDto) {
        List<Despesa> parcelas = parcelaService.save(parcelaDto);

        if (parcelas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(parcelas);
    }


    @PutMapping
    public ResponseEntity<Object> update(@RequestBody ParcelaDto parcelaDto) {
        try {
            Despesa despesa = parcelaService.update(parcelaDto);
            System.out.println("AQUIIII");
            return ResponseEntity.ok(despesa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível alterar a multa: " + e.getMessage());
        }
    }

    @PutMapping("/gasto")
    public ResponseEntity<Object> updateGasto(@RequestBody Gasto gasto) {
        try {
            Despesa despesa = parcelaService.updateGasto(gasto);
            return ResponseEntity.ok(despesa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível alterar a multa: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (parcelaService.delete(id)) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", 200);
            response.put("message", "Parcela deletada com sucesso.");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body("Erro ao deletar parcela.");
    }
}