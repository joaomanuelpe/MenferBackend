package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.entities.Acesso;
import com.example.backendmenferlog.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/acesso")
public class AcessoRestController {
    @Autowired
    private AcessoService acessoService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(acessoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Acesso> add(@RequestBody  Acesso acesso) {
        return ResponseEntity.ok(acessoService.add(acesso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acesso> update(@PathVariable Long id, @RequestBody Acesso acesso) {
        return ResponseEntity.ok(acessoService.update(id, acesso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Acesso> delete(@PathVariable Long id) {
        acessoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
