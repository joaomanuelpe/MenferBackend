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
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/motorista")
public class MotoristaRestController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Motorista> motoristaList = motoristaService.getAll();
        if(!motoristaList.isEmpty()) {
            List<MotoristaDTO> dtoList = motoristaList.stream()
                    .map(MotoristaDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
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
    public ResponseEntity<Object> postMotorista(@RequestParam("cpf") String cpf,
                                                @RequestParam("name") String name,
                                                @RequestParam(value = "phone", required = false) String phone,
                                                @RequestParam(value = "rg", required = false) String rg,
                                                @RequestParam(value = "licenseExpiryDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate licenseExpiryDate,
                                                @RequestParam(value = "birthDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                                                @RequestParam(value = "logradouro", required = false) String logradouro,
                                                @RequestParam(value = "numero", required = false) String numero,
                                                @RequestParam(value = "complemento", required = false) String complemento,
                                                @RequestParam(value = "bairro", required = false) String bairro,
                                                @RequestParam(value = "cidade", required = false) String cidade,
                                                @RequestParam(value = "estado", required = false) String estado,
                                                @RequestParam(value = "cep", required = false) String cep,
                                                @RequestParam(value = "cnh", required = false) String cnh,
                                                @RequestParam(value = "cetpp", required = false) String cetpp,
                                                @RequestParam(value = "arqCnh", required = false) MultipartFile arqCnh,
                                                @RequestParam(value = "comprovanteRs", required = false) MultipartFile comprovanteRs,
                                                @RequestParam(value = "arqCetpp", required = false) MultipartFile arqCetpp,
                                                @RequestParam(value = "arqExamTox", required = false) MultipartFile arqExamTox,
                                                @RequestParam(value = "arqAso", required = false) MultipartFile arqAso) throws IOException {
        byte[] arqCnhBytea = arqCnh != null ? arqCnh.getBytes() : null;
        byte[] comprovanteRsBytea = comprovanteRs != null ? comprovanteRs.getBytes() : null;
        byte[] arqCetppBytea = arqCetpp != null ? arqCetpp.getBytes() : null;
        byte[] arqExamToxBytea = arqExamTox != null ? arqExamTox.getBytes() : null;
        byte[] arqAsoBytea = arqAso != null ? arqAso.getBytes() : null;

        Motorista motorista = new Motorista(
                cpf,
                name,
                phone,
                rg,
                licenseExpiryDate,
                birthDate,
                logradouro,
                numero,
                complemento != null ? complemento : "",
                bairro,
                cidade,
                estado,
                cep,
                cnh,
                cetpp,
                arqCnhBytea,
                comprovanteRsBytea,
                arqCetppBytea,
                arqExamToxBytea,
                arqAsoBytea
        );

        Motorista novoMotorista = motoristaService.add(motorista);
        if(novoMotorista != null)
            return ResponseEntity.ok(new MotoristaDTO(novoMotorista));
        return ResponseEntity.badRequest().body("Erro ao cadastrar motorista");
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Object> putMotorista(@PathVariable String cpf, @RequestBody Motorista motorista) {
        Motorista motorista1 = motoristaService.get(cpf);
        if(motorista1 != null) {
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
