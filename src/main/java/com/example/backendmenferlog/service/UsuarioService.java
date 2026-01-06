package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Usuario;
import com.example.backendmenferlog.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario add(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario get(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public boolean delete(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        try {
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
