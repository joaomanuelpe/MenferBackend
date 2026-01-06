package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.entities.Cliente;
import com.example.backendmenferlog.entities.Veiculo;
import com.example.backendmenferlog.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/veiculo")
public class VeiculoRestController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping(value = "/{placa}")
    public ResponseEntity<Object> get (@PathVariable(name = "placa") String placa) {
        Veiculo veiculo = veiculoService.get(placa);
        if (veiculo != null)
            return ResponseEntity.ok(veiculo);
        return ResponseEntity.badRequest().body("Não foi possível recuperar o veículo.");
    }

    @GetMapping
    public ResponseEntity<Object> getAll () {
        List<Veiculo> veiculos = veiculoService.getAll();
        if (!veiculos.isEmpty())
            return ResponseEntity.ok(veiculos);
        return ResponseEntity.badRequest().body("Não foi possível recuperar os veículos.");
    }

    @GetMapping("/cavalo")
    public ResponseEntity<Object> getCavalo () {
        List<Veiculo> veiculos = veiculoService.getAllCavalos();
        if (!veiculos.isEmpty())
            return ResponseEntity.ok(veiculos);
        return ResponseEntity.badRequest().body("Não foi possível recuperar os cavalos.");
    }

    @GetMapping("/reboque")
    public ResponseEntity<Object> getReboque () {
        List<Veiculo> veiculos = veiculoService.getAllReboques();
        if (!veiculos.isEmpty())
            return ResponseEntity.ok(veiculos);
        return ResponseEntity.badRequest().body("Não foi possível recuperar os reboques.");
    }

    @PostMapping
    public ResponseEntity<Object> save (
            @RequestParam String placa,
            @RequestParam String tipo,
            @RequestParam String renavam,
            @RequestParam String marca,
            @RequestParam String modelo,
            @RequestParam String chassi,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate licenciamento,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expiraLicenciamento,
            @RequestParam String anttText,
            @RequestParam(required = false) MultipartFile antt,  // Arquivo opcional
            @RequestParam String idRastreador,
            @RequestParam String empresaRastreador,
            @RequestParam(required = false) MultipartFile contratoArrendamento,  // Arquivo opcional
            @RequestParam String civ,
            @RequestParam String civNumero,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expiraCiv,
            @RequestParam(required = false) MultipartFile arqCrlv,  // Arquivo opcional
            @RequestParam(required = false) MultipartFile arqCrono,  // Arquivo opcional
            @RequestParam(required = false) MultipartFile arqLaudoOpa  // Arquivo opcional
    ) throws IOException {

        byte[] anttBytes = antt != null ? antt.getBytes() : null;
        byte[] contratoBytes = contratoArrendamento != null ? contratoArrendamento.getBytes() : null;
        byte[] arqCrlvBytes = arqCrlv != null ? arqCrlv.getBytes() : null;
        byte[] arqCronoBytes = arqCrono != null ? arqCrono.getBytes() : null;
        byte[] arqLaudoOpaBytes = arqLaudoOpa != null ? arqLaudoOpa.getBytes() : null;

        Veiculo veiculo = new Veiculo(
                placa,
                tipo,
                renavam,
                marca,
                modelo,
                chassi,
                licenciamento,
                expiraLicenciamento,
                anttText,
                anttBytes,
                idRastreador,
                empresaRastreador,
                contratoBytes,
                civ,
                civNumero,
                expiraCiv,
                arqCrlvBytes,
                arqCronoBytes,
                arqLaudoOpaBytes
        );
        System.out.println(placa);

        Veiculo novoVeiculo = veiculoService.save(veiculo);

        if (novoVeiculo != null)
            return ResponseEntity.ok(novoVeiculo);
        return ResponseEntity.badRequest().body("Não foi possivel adicionar o veiculo.");
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Veiculo veiculo) {
        try {
            Veiculo veiculo1 = veiculoService.save(veiculo);
            return ResponseEntity.ok("Veículo alterado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar veículo!");
        }
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Object> delete(@PathVariable String placa) {
        boolean flag = veiculoService.delete(placa);
        if (flag)
            return ResponseEntity.ok("Veículo excluído com sucesso!");
        return ResponseEntity.badRequest().body("Erro ao excluir veículo!");
    }
}
