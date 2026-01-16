package com.example.backendmenferlog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "motorista")
public class Motorista {

    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "rg")
    private String rg;

    @Column(name = "\"licenseExpiryDate\"")
    private LocalDate licenseExpiryDate;

    @Column(name = "\"birthDate\"")
    private LocalDate birthDate;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cnh")
    private String cnh;

    @Column(name = "cetpp")
    private String cetpp;

    @Column(name = "\"arqCnh\"")
    private byte[] arqCnh;

    @Column(name = "\"comprovanteRs\"")
    private byte[] comprovanteRs;

    @Column(name = "\"arqCetpp\"")
    private byte[] arqCetpp;

    @Column(name = "\"arqExamTox\"")
    private byte[] arqExamTox;

    @Column(name = "\"arqAso\"")
    private byte[] arqAso;

    public Motorista() {
    }

    public Motorista(String cpf, String name, String phone, String rg, LocalDate licenseExpiryDate,
                     LocalDate birthDate, String logradouro, String numero, String complemento,
                     String bairro, String cidade, String estado, String cep, String cnh, String cetpp,
                     byte[] arqCnh, byte[] comprovanteRs, byte[] arqCetpp, byte[] arqExamTox, byte[] arqAso) {
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
        this.rg = rg;
        this.licenseExpiryDate = licenseExpiryDate;
        this.birthDate = birthDate;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.cnh = cnh;
        this.cetpp = cetpp;
        this.arqCnh = arqCnh;
        this.comprovanteRs = comprovanteRs;
        this.arqCetpp = arqCetpp;
        this.arqExamTox = arqExamTox;
        this.arqAso = arqAso;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public LocalDate getLicenseExpiryDate() { return licenseExpiryDate; }
    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) { this.licenseExpiryDate = licenseExpiryDate; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

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

    public String getCnh() { return cnh; }
    public void setCnh(String cnh) { this.cnh = cnh; }

    public String getCetpp() { return cetpp; }
    public void setCetpp(String cetpp) { this.cetpp = cetpp; }

    public byte[] getArqCnh() { return arqCnh; }
    public void setArqCnh(byte[] arqCnh) { this.arqCnh = arqCnh; }

    public byte[] getComprovanteRs() { return comprovanteRs; }
    public void setComprovanteRs(byte[] comprovanteRs) { this.comprovanteRs = comprovanteRs; }

    public byte[] getArqCetpp() { return arqCetpp; }
    public void setArqCetpp(byte[] arqCetpp) { this.arqCetpp = arqCetpp; }

    public byte[] getArqExamTox() { return arqExamTox; }
    public void setArqExamTox(byte[] arqExamTox) { this.arqExamTox = arqExamTox; }

    public byte[] getArqAso() { return arqAso; }
    public void setArqAso(byte[] arqAso) { this.arqAso = arqAso; }
}
