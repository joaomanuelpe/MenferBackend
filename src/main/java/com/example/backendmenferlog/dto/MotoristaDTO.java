package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.Motorista;

import java.util.Base64;

public class MotoristaDTO {
    private String cpf;
    private String name;
    private String phone;
    private String rg;
    private String licenseExpiryDate;
    private String birthDate;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String cnh;
    private String cetpp;
    private String arqCnhBase64;
    private String comprovanteRsBase64;
    private String arqCetppBase64;
    private String arqExamToxBase64;
    private String arqAsoBase64;

    public MotoristaDTO(Motorista motorista) {
        this.cpf = motorista.getCpf();
        this.name = motorista.getName();
        this.phone = motorista.getPhone();
        this.rg = motorista.getRg();
        this.licenseExpiryDate = motorista.getLicenseExpiryDate() != null ? motorista.getLicenseExpiryDate().toString() : null;
        this.birthDate = motorista.getBirthDate() != null ? motorista.getBirthDate().toString() : null;
        this.logradouro = motorista.getLogradouro();
        this.numero = motorista.getNumero();
        this.complemento = motorista.getComplemento();
        this.bairro = motorista.getBairro();
        this.cidade = motorista.getCidade();
        this.estado = motorista.getEstado();
        this.cep = motorista.getCep();
        this.cnh = motorista.getCnh();
        this.cetpp = motorista.getCetpp();

        this.arqCnhBase64 = motorista.getArqCnh() != null ? Base64.getEncoder().encodeToString(motorista.getArqCnh()) : null;
        this.comprovanteRsBase64 = motorista.getComprovanteRs() != null ? Base64.getEncoder().encodeToString(motorista.getComprovanteRs()) : null;
        this.arqCetppBase64 = motorista.getArqCetpp() != null ? Base64.getEncoder().encodeToString(motorista.getArqCetpp()) : null;
        this.arqExamToxBase64 = motorista.getArqExamTox() != null ? Base64.getEncoder().encodeToString(motorista.getArqExamTox()) : null;
        this.arqAsoBase64 = motorista.getArqAso() != null ? Base64.getEncoder().encodeToString(motorista.getArqAso()) : null;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public String getLicenseExpiryDate() { return licenseExpiryDate; }
    public void setLicenseExpiryDate(String licenseExpiryDate) { this.licenseExpiryDate = licenseExpiryDate; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

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

    public String getArqCnhBase64() { return arqCnhBase64; }
    public void setArqCnhBase64(String arqCnhBase64) { this.arqCnhBase64 = arqCnhBase64; }

    public String getComprovanteRsBase64() { return comprovanteRsBase64; }
    public void setComprovanteRsBase64(String comprovanteRsBase64) { this.comprovanteRsBase64 = comprovanteRsBase64; }

    public String getArqCetppBase64() { return arqCetppBase64; }
    public void setArqCetppBase64(String arqCetppBase64) { this.arqCetppBase64 = arqCetppBase64; }

    public String getArqExamToxBase64() { return arqExamToxBase64; }
    public void setArqExamToxBase64(String arqExamToxBase64) { this.arqExamToxBase64 = arqExamToxBase64; }

    public String getArqAsoBase64() { return arqAsoBase64; }
    public void setArqAsoBase64(String arqAsoBase64) { this.arqAsoBase64 = arqAsoBase64; }
}
