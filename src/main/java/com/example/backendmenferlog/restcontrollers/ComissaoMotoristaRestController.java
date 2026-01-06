package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.ComissaoMotoristaDTO;
import com.example.backendmenferlog.dto.ComissaoMotoristaResponseDTO;
import com.example.backendmenferlog.service.ComissaoMotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/comissao-motorista")
public class ComissaoMotoristaRestController {

    @Autowired
    private ComissaoMotoristaService comissaoMotoristaService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        try {
            List<ComissaoMotoristaResponseDTO> comissoes = comissaoMotoristaService.getAll();
            if (comissoes.isEmpty()) {
                return ResponseEntity.badRequest().body("Não foram encontradas comissões!");
            }
            return ResponseEntity.ok().body(Map.of("status", 200, "comissoes", comissoes));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar as comissões: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            ComissaoMotoristaResponseDTO comissao = comissaoMotoristaService.getById(id);
            return ResponseEntity.ok().body(Map.of("status", 200, "comissoes", List.of(comissao)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("status", 400, "message", "Não foram encontradas comissões!"));
        }
    }

    @GetMapping("/viagem/{idDaViagem}")
    public ResponseEntity<Object> getByViagem(@PathVariable Long idDaViagem) {
        try {
            List<ComissaoMotoristaResponseDTO> comissoes = comissaoMotoristaService.getByViagem(idDaViagem);
            return ResponseEntity.ok(comissoes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar comissões por viagem: " + e.getMessage());
        }
    }

    @GetMapping("/motorista/{motorista}")
    public ResponseEntity<Object> getByMotorista(@PathVariable String motorista) {
        try {
            List<ComissaoMotoristaResponseDTO> comissoes = comissaoMotoristaService.getByMotorista(motorista);
            return ResponseEntity.ok(comissoes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar comissões por motorista: " + e.getMessage());
        }
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<Object> getEstatisticas(
            @RequestParam(required = false) Long idDaViagem,
            @RequestParam(required = false) String motorista) {
        try {
            Map<String, Object> estatisticas = comissaoMotoristaService.getEstatisticas(idDaViagem, motorista);
            return ResponseEntity.ok(estatisticas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao obter estatísticas: " + e.getMessage());
        }
    }

    /**
     * MÉTODO CORRIGIDO - Agora aceita List<ComissaoMotoristaDTO> diretamente
     */
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody List<ComissaoMotoristaDTO> comissoesDto) {
        try {
            // Validação básica
            if (comissoesDto == null || comissoesDto.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", 400,
                        "message", "A lista de comissões não pode estar vazia"
                ));
            }

            System.out.println("📥 Recebendo " + comissoesDto.size() + " comissão(ões)");

            // Validar cada comissão
            for (int i = 0; i < comissoesDto.size(); i++) {
                ComissaoMotoristaDTO dto = comissoesDto.get(i);
                System.out.println("Comissão " + (i + 1) + ": " + dto);

                if (dto.getIdDaViagem() == null) {
                    return ResponseEntity.badRequest().body(Map.of(
                            "status", 400,
                            "message", "Comissão " + (i + 1) + ": campo 'idDaViagem' é obrigatório"
                    ));
                }
                if (dto.getVale() == null) {
                    return ResponseEntity.badRequest().body(Map.of(
                            "status", 400,
                            "message", "Comissão " + (i + 1) + ": campo 'valePedagio' é obrigatório"
                    ));
                }
                if (dto.getComissao() == null) {
                    return ResponseEntity.badRequest().body(Map.of(
                            "status", 400,
                            "message", "Comissão " + (i + 1) + ": campo 'comissao' é obrigatório"
                    ));
                }
            }

            // Processar múltiplas comissões
            List<ComissaoMotoristaResponseDTO> comissoes = comissaoMotoristaService.saveMultiple(comissoesDto);

            System.out.println("✅ " + comissoes.size() + " comissão(ões) salva(s) com sucesso");

            return ResponseEntity.ok().body(Map.of(
                    "status", 200,
                    "message", comissoes.size() + " comissão(ões) cadastrada(s) com sucesso!",
                    "results", comissoes.stream().map(c -> Map.of(
                            "success", true,
                            "idComissao", c.getIdComissao(),
                            "idDaViagem", c.getIdDaViagem(),
                            "comissao", c.getComissao(),
                            "valePedagio", c.getVale()
                    )).toList()
            ));
        } catch (Exception e) {
            System.err.println("❌ Erro ao processar comissões: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Map.of(
                    "status", 400,
                    "message", "Erro ao cadastrar comissões: " + e.getMessage()
            ));
        }
    }

    /**
     * NOVO MÉTODO - Para salvar apenas UMA comissão
     */
    @PostMapping("/single")
    public ResponseEntity<Object> saveSingle(@RequestBody ComissaoMotoristaDTO comissaoDto) {
        try {
            if (comissaoDto.getIdDaViagem() == null) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", 400,
                        "message", "Campo 'idDaViagem' é obrigatório"
                ));
            }

            ComissaoMotoristaResponseDTO comissao = comissaoMotoristaService.save(comissaoDto);

            return ResponseEntity.ok().body(Map.of(
                    "status", 200,
                    "message", "Comissão cadastrada com sucesso!",
                    "comissao", comissao
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", 400,
                    "message", "Erro ao cadastrar comissão: " + e.getMessage()
            ));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ComissaoMotoristaDTO comissaoDto) {
        try {
            comissaoDto.setIdComissao(id);
            ComissaoMotoristaResponseDTO comissao = comissaoMotoristaService.update(comissaoDto);
            return ResponseEntity.ok().body(Map.of("message", "Comissão atualizada com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("status", 400, "message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (comissaoMotoristaService.delete(id)) {
            return ResponseEntity.ok().body(Map.of("status", 200, "message", "Comissão excluída com sucesso!"));
        }
        return ResponseEntity.badRequest().body(Map.of("message", "ID não informado ou comissão não encontrada!"));
    }
}
