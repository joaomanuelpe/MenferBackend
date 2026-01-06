package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.AbastecimentoDTO;
import com.example.backendmenferlog.dto.AbastecimentoResponseDTO;
import com.example.backendmenferlog.dto.EstatisticasDTO;
import com.example.backendmenferlog.service.AbastecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoRestController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        try {
            List<AbastecimentoResponseDTO> abastecimentos = abastecimentoService.getAll();
            if (abastecimentos.isEmpty()) {
                return ResponseEntity.badRequest().body("Não foram encontrados abastecimentos!");
            }
            return ResponseEntity.ok().body(Map.of("status", 200, "abastecimentos", abastecimentos));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar os abastecimentos: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            AbastecimentoResponseDTO abastecimento = abastecimentoService.getById(id);
            return ResponseEntity.ok().body(Map.of("status", 200, "abastecimentos", List.of(abastecimento)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("status", 400, "message", "Não foram encontrados abastecimentos!"));
        }
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Object> getByPlaca(@PathVariable String placa) {
        try {
            List<AbastecimentoResponseDTO> abastecimentos = abastecimentoService.getByPlaca(placa);
            return ResponseEntity.ok(abastecimentos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar abastecimentos por placa: " + e.getMessage());
        }
    }

    @GetMapping("/periodo")
    public ResponseEntity<Object> getByPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        try {
            List<AbastecimentoResponseDTO> abastecimentos = abastecimentoService.getByPeriodo(dataInicial, dataFinal);
            return ResponseEntity.ok(abastecimentos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar abastecimentos por período: " + e.getMessage());
        }
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<Object> getEstatisticas(
            @RequestParam(required = false) String placa,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        try {
            EstatisticasDTO estatisticas = abastecimentoService.getEstatisticas(placa, dataInicial, dataFinal);
            return ResponseEntity.ok(estatisticas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao obter estatísticas: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AbastecimentoDTO abastecimentoDto) {
        try {
            AbastecimentoResponseDTO abastecimento = abastecimentoService.save(abastecimentoDto);
            return ResponseEntity.ok().body(Map.of("message", "Abastecimento incluído com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody AbastecimentoDTO abastecimentoDto) {
        try {
            AbastecimentoResponseDTO abastecimento = abastecimentoService.update(abastecimentoDto);
            return ResponseEntity.ok().body(Map.of("message", "Abastecimento alterado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("status", 400, "message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (abastecimentoService.delete(id)) {
            return ResponseEntity.ok().body(Map.of("status", 200, "message", "Abastecimento excluído com sucesso!"));
        }
        return ResponseEntity.badRequest().body(Map.of("message", "ID não informado ou abastecimento não encontrado!"));
    }
}
