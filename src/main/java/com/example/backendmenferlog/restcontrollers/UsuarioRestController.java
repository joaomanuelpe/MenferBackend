package com.example.backendmenferlog.restcontrollers;

import com.example.backendmenferlog.entities.Usuario;
import com.example.backendmenferlog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Usuario> usuarios = usuarioService.getAll();
        if (!usuarios.isEmpty())
            return ResponseEntity.ok(usuarios);
        return ResponseEntity.badRequest().body("Não há nenhum usuário!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id) {
        Usuario usuario = usuarioService.get(id);
        if (usuario != null)
            return ResponseEntity.ok(usuario);
        return ResponseEntity.badRequest().body("Erro ao recuperar usuário!");
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.add(usuario);
        if (novoUsuario != null)
            return ResponseEntity.ok(novoUsuario);
        return ResponseEntity.badRequest().body("Erro ao inserir usuário!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        boolean flag = usuarioService.delete(id);
        if (flag)
            return ResponseEntity.ok("Usuário excluído com sucesso!");
        return ResponseEntity.badRequest().body("Erro ao excluir usuário!");
    }
}
