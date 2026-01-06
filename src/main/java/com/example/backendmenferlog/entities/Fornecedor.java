package com.example.backendmenferlog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "\"razaoSocial\"", nullable = false)
    private String razaoSocial;

    @Column(name = "\"inscricaoEstadual\"", nullable = false)
    private String inscricaoEstadual;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "contato", nullable = false)
    private String contato;

    public Fornecedor() {
        this("", "", "", "", "", "", "");
    }

    public Fornecedor (String cnpj, String razaoSocial, String inscricaoEstadual,String endereco, String email, String telefone, String contato) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
