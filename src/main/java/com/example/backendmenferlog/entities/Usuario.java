package com.example.backendmenferlog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idUsuario\"")
    private Integer idUsuario;

    @Column(name = "\"nomeUsuario\"", nullable = false)
    private String nomeUsuario;

    @Column(name = "\"senhaUsuario\"", nullable = false)
    private String senhaUsuario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "\"nivelAcesso\"", nullable = false)
    private String nivelAcesso;

    public Usuario() {
        this(0, "", "", "", "");
    }

    public Usuario(Integer idUsuario, String nomeUsuario, String senhaUsuario,
                   String email, String nivelAcesso) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
