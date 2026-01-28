package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.entities.Veiculo;
import com.example.backendmenferlog.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String renavam,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String chassi,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate licenciamento,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expiraLicenciamento,
            @RequestParam(required = false) String anttText,
            @RequestParam(required = false) MultipartFile antt,
            @RequestParam(required = false) String idRastreador,
            @RequestParam(required = false) String empresaRastreador,
            @RequestParam(required = false) MultipartFile contratoArrendamento,
            @RequestParam(required = false) String civ,
            @RequestParam(required = false) String civNumero,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expiraCiv,
            @RequestParam(required = false) MultipartFile arqCrlv,
            @RequestParam(required = false) MultipartFile arqCrono,
            @RequestParam(required = false) MultipartFile arqLaudoOpa
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

        Veiculo novoVeiculo = veiculoService.save(veiculo);

        return ResponseEntity.ok(novoVeiculo);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> update(
            @RequestParam String placa,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String renavam,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String chassi,
            @RequestParam(required = false) String anttText,
            @RequestParam(required = false) LocalDate licenciamento,
            @RequestParam(required = false) LocalDate expiraLicenciamento,
            @RequestParam(required = false) String civ,
            @RequestParam(required = false) String civNumero,
            @RequestParam(required = false) LocalDate expiraCiv,
            @RequestParam(required = false) String idRastreador,
            @RequestParam(required = false) String empresaRastreador,

            @RequestParam(required = false) MultipartFile antt,
            @RequestParam(required = false) MultipartFile contratoArrendamento,
            @RequestParam(required = false) MultipartFile arqCrlv,
            @RequestParam(required = false) MultipartFile arqCrono,
            @RequestParam(required = false) MultipartFile arqLaudoOpa
    ) throws IOException {

        Veiculo veiculo = veiculoService.get(placa);

        if (tipo != null) veiculo.setTipo(tipo);
        if (renavam != null) veiculo.setRenavam(renavam);
        if (marca != null) veiculo.setMarca(marca);
        if (modelo != null) veiculo.setModelo(modelo);
        if (chassi != null) veiculo.setChassi(chassi);
        if (anttText != null) veiculo.setAnttText(anttText);
        if (licenciamento != null) veiculo.setLicenciamento(licenciamento);
        if (expiraLicenciamento != null) veiculo.setExpiraLicenciamento(expiraLicenciamento);
        if (civ != null) veiculo.setCiv(civ);
        if (civNumero != null) veiculo.setCivNumero(civNumero);
        if (expiraCiv != null) veiculo.setExpiraCiv(expiraCiv);
        if (idRastreador != null) veiculo.setIdRastreador(idRastreador);
        if (empresaRastreador != null) veiculo.setEmpresaRastreador(empresaRastreador);

        if (antt != null && !antt.isEmpty()) veiculo.setAntt(antt.getBytes());
        if (contratoArrendamento != null && !contratoArrendamento.isEmpty())
            veiculo.setContratoArrendamento(contratoArrendamento.getBytes());
        if (arqCrlv != null && !arqCrlv.isEmpty()) veiculo.setArqCrlv(arqCrlv.getBytes());
        if (arqCrono != null && !arqCrono.isEmpty()) veiculo.setArqCrono(arqCrono.getBytes());
        if (arqLaudoOpa != null && !arqLaudoOpa.isEmpty())
            veiculo.setArqLaudoOpa(arqLaudoOpa.getBytes());

        veiculoService.update(veiculo);

        return ResponseEntity.ok("Veículo alterado com sucesso!");
    }


    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> delete(@PathVariable String placa) {
        veiculoService.delete(placa);
        return ResponseEntity.noContent().build();
    }
}
