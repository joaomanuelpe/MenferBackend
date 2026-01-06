package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.ViagemDTO;
import com.example.backendmenferlog.dto.ViagemResponseDTO;
import com.example.backendmenferlog.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/viagem")
public class ViagemRestController {

    @Autowired
    private ViagemService viagemService;

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody Object body) {
        try {
            List<ViagemDTO> viagensDTO;

            if (body instanceof List) {
                viagensDTO = ((List<?>) body).stream()
                        .map(item -> {
                            if (item instanceof Map) {
                                return mapToViagemDTO((Map<String, Object>) item);
                            }
                            return (ViagemDTO) item;
                        })
                        .toList();
            } else if (body instanceof Map) {
                viagensDTO = List.of(mapToViagemDTO((Map<String, Object>) body));
            } else {
                viagensDTO = List.of((ViagemDTO) body);
            }

            List<ViagemResponseDTO> results = viagemService.gravar(viagensDTO);

            Map<String, Object> response = new HashMap<>();
            response.put("status", 200);
            response.put("message", results.size() + " viagem(ns) processada(s) com sucesso!");
            response.put("results", results);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 500);
            errorResponse.put("message", "Erro ao processar as viagens: " + e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody ViagemDTO viagemDTO) {
        try {
            ViagemResponseDTO viagemAtualizada = viagemService.atualizar(id, viagemDTO);
            return ResponseEntity.ok(viagemAtualizada);
        } catch (RuntimeException e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }


    @GetMapping
    public ResponseEntity<Object> consultar() {
        try {
            List<ViagemResponseDTO> viagens = viagemService.consultar(null);
            return ResponseEntity.ok(viagens);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Erro ao consultar as viagens: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultarPorId(@PathVariable Long id) {
        try {
            List<ViagemResponseDTO> viagens = viagemService.consultar(id);
            return ResponseEntity.ok(viagens);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Erro ao consultar as viagens: " + e.getMessage()));
        }
    }

    @GetMapping("/motorista/{motorista}")
    public ResponseEntity<Object> consultarViagemDeUmMotorista(@PathVariable String motorista) {
        try {
            List<ViagemResponseDTO> viagens = viagemService.consultarViagemDeUmMotorista(motorista);
            return ResponseEntity.ok(viagens);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Erro ao consultar as viagens: " + e.getMessage()));
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> excluir(@RequestBody(required = false) Map<String, Object> body) {
        try {
            Long idViagem = null;
            if (body != null && body.containsKey("idViagem")) {
                Object idValue = body.get("idViagem");
                if (idValue instanceof Number) {
                    idViagem = ((Number) idValue).longValue();
                }
            }

            boolean resultado = viagemService.excluir(idViagem);

            if (resultado) {
                String message = idViagem != null ?
                        "Viagem excluída com sucesso!" :
                        "Todas as viagens foram excluídas com sucesso!";
                return ResponseEntity.ok(Map.of("message", message));
            } else {
                return ResponseEntity.badRequest().body(Map.of("message", "Viagem não encontrada!"));
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Erro ao excluir as viagens: " + e.getMessage()));
        }
    }

    private ViagemDTO mapToViagemDTO(Map<String, Object> map) {
        ViagemDTO dto = new ViagemDTO();

        if (map.get("id") != null) dto.setId(((Number) map.get("id")).longValue());
        if (map.get("empresa") != null) dto.setEmpresa((String) map.get("empresa"));
        if (map.get("data") != null) dto.setData(java.time.LocalDate.parse((String) map.get("data")));
        if (map.get("cte") != null) dto.setCte((String) map.get("cte"));
        if (map.get("peso") != null) dto.setPeso(((Number) map.get("peso")).doubleValue());
        if (map.get("numContainer") != null) dto.setNumContainer((String) map.get("numContainer"));
        if (map.get("tamContainer") != null) dto.setTamContainer(((Number) map.get("tamContainer")).doubleValue());
        if (map.get("tipoContainer") != null) dto.setTipoContainer((String) map.get("tipoContainer"));
        if (map.get("placaCavalo") != null) dto.setPlacaCavalo((String) map.get("placaCavalo"));
        if (map.get("placaReboque") != null) dto.setPlacaReboque((String) map.get("placaReboque"));
        if (map.get("motorista") != null) dto.setMotorista((String) map.get("motorista"));
        if (map.get("origem") != null) dto.setOrigem((String) map.get("origem"));
        if (map.get("destino") != null) dto.setDestino((String) map.get("destino"));
        if (map.get("entrega") != null) dto.setEntrega(java.time.LocalDate.parse((String) map.get("entrega")));
        if (map.get("horaDeChegada") != null) dto.setHoraDeChegada(java.time.LocalTime.parse((String) map.get("horaDeChegada")));
        if (map.get("horaDeSaida") != null) dto.setHoraDeSaida(java.time.LocalTime.parse((String) map.get("horaDeSaida")));
        if (map.get("tipoDeOperacao") != null) dto.setTipoDeOperacao((String) map.get("tipoDeOperacao"));
        if (map.get("valePedagio") != null) dto.setValePedagio((Boolean) map.get("valePedagio"));
        if (map.get("valorPedagio") != null) dto.setValorPedagio(((Number) map.get("valorPedagio")).doubleValue());
        if (map.get("adiantamento") != null) dto.setAdiantamento(((Number) map.get("adiantamento")).doubleValue());
        if (map.get("saldo") != null) dto.setSaldo(((Number) map.get("saldo")).doubleValue());
        if (map.get("antecipacaoTerm") != null) dto.setAntecipacaoTerm((Boolean) map.get("antecipacaoTerm"));
        if (map.get("valorTerminal") != null) dto.setValorTerminal(((Number) map.get("valorTerminal")).doubleValue());
        if (map.get("estadia") != null) dto.setEstadia((Boolean) map.get("estadia"));
        if (map.get("valorEstadia") != null) dto.setValorEstadia(((Number) map.get("valorEstadia")).doubleValue());
        if (map.get("numeroFatur") != null) dto.setNumeroFatur(((String) map.get("numeroFatur")));
        if (map.get("diaPgto") != null) dto.setDiaPgto(java.time.LocalDate.parse((String) map.get("diaPgto")));
        if (map.get("status") != null) dto.setStatus((String) map.get("status"));

        return dto;
    }
}