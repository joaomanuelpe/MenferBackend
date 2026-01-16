package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.Cliente;

public class ClienteDTO {
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String email;
    private String telefone;
    private String contato;

    public ClienteDTO(Cliente cliente) {
        this.cnpj = cliente.getCnpj();
        this.razaoSocial = cliente.getRazaoSocial();
        this.inscricaoEstadual = cliente.getInscricaoEstadual();
        this.logradouro = cliente.getLogradouro();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getComplemento();
        this.bairro = cliente.getBairro();
        this.cidade = cliente.getCidade();
        this.estado = cliente.getEstado();
        this.cep = cliente.getCep();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.contato = cliente.getContato();
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    public String getInscricaoEstadual() { return inscricaoEstadual; }
    public void setInscricaoEstadual(String inscricaoEstadual) { this.inscricaoEstadual = inscricaoEstadual; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
}
