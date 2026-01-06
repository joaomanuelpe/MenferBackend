package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.dto.MotoristaDTO;
import com.example.backendmenferlog.entities.Motorista;
import com.example.backendmenferlog.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/motorista")
public class MotoristaRestController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Motorista> motoristaList = motoristaService.getAll();
        if(!motoristaList.isEmpty())
            return ResponseEntity.ok(motoristaList);
        return ResponseEntity.badRequest().body("Não há nenhum motorista cadastrado");
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getMotorista(@PathVariable String cpf) {
        Motorista motorista = motoristaService.get(cpf);
        if(motorista != null)
            return ResponseEntity.ok(new MotoristaDTO(motorista));
        return ResponseEntity.badRequest().body("Não foi encontrado o motorista com o cpf: " + cpf);
    }

    @PostMapping
    public ResponseEntity<Object> postMotorista(@RequestParam String name,
                                                @RequestParam String phone,
                                                @RequestParam String rg,
                                                @RequestParam String cpf,
                                                @RequestParam String registrationNumber,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate licenseExpiryDate,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                                                @RequestParam String address,
                                                @RequestParam String cnh,
                                                @RequestParam String cetpp,
                                                @RequestParam(required = false) MultipartFile arqCnh,
                                                @RequestParam(required = false) MultipartFile comprovanteRs,
                                                @RequestParam(required = false) MultipartFile arqCetpp,
                                                @RequestParam(required = false) MultipartFile arqExamTox,
                                                @RequestParam(required = false) MultipartFile arqAso) throws IOException {
        byte[] arqCnhBytea = arqCnh != null ? arqCnh.getBytes() : null;
        byte[] comprovanteRsBytea = comprovanteRs != null ? comprovanteRs.getBytes() : null;
        byte[] arqCetppBytea = arqCetpp != null ? arqCetpp.getBytes() : null;
        byte[] arqExamToxBytea = arqExamTox != null ? arqExamTox.getBytes() : null;
        byte[] arqAsoBytea = arqAso != null ? arqAso.getBytes() : null;

        // CONSTRUTOR ATUALIZADO COM birthDate
        Motorista motorista = new Motorista(cpf, name, phone, registrationNumber, licenseExpiryDate, birthDate, address,
                cnh,
                arqCnhBytea,
                comprovanteRsBytea,
                cetpp,
                arqCetppBytea,
                arqExamToxBytea,
                arqAsoBytea,
                rg
        );
        Motorista novoMotorista = motoristaService.add(motorista);
        if(novoMotorista != null)
            return ResponseEntity.ok(novoMotorista);
        return ResponseEntity.badRequest().body("Erro ao cadastrar motorista");
    }

    // CORRIGIDO: Agora aceita CPF na URL
    @PutMapping("/{cpf}")
    public ResponseEntity<Object> putMotorista(@PathVariable String cpf, @RequestBody Motorista motorista) {
        Motorista motorista1 = motoristaService.get(cpf);
        if(motorista1 != null) {
            // Garantir que o CPF da URL seja usado
            motorista.setCpf(cpf);
            Motorista motorista2 = motoristaService.add(motorista);
            return ResponseEntity.ok("Motorista de cpf: " + cpf + " foi atualizado com sucesso!");
        }
        return ResponseEntity.badRequest().body("Erro ao atualizar motorista de cpf: " + cpf);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deleteMotorista(@PathVariable String cpf) {
        boolean flag = motoristaService.delete(cpf);
        if(flag)
            return ResponseEntity.ok("Motorista de cpf: " + cpf + " foi deletado com sucesso!");
        return ResponseEntity.badRequest().body("Motorista de cpf: " + cpf + " não foi deletado");
    }
}