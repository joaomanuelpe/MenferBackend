package com.example.backendmenferlog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "\"registrationNumber\"")
    private String registrationNumber;

    @Column(name = "\"licenseExpiryDate\"")
    private LocalDate licenseExpiryDate;

    @Column(name = "\"birthDate\"")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "cnh")
    private String cnh;

    @Column(name = "\"arqCnh\"")
    private byte[] arqCnh;

    @Column(name = "\"comprovanteRs\"")
    private byte[] comprovanteRs;

    @Column(name = "cetpp")
    private String cetpp;

    @Column(name = "\"arqCetpp\"")
    private byte[] arqCetpp;

    @Column(name = "\"arqExamTox\"")
    private byte[] arqExamTox;

    @Column(name = "\"arqAso\"")
    private byte[] arqAso;

    @Column(name = "rg")
    private String rg;

    public Motorista() {
        this("", "", "", "", null, null, "", "", null, null, "", null, null, null, "");
    }

    // CONSTRUTOR ATUALIZADO COM birthDate
    public Motorista(String cpf, String name, String phone, String registrationNumber, LocalDate licenseExpiryDate, LocalDate birthDate, String address, String cnh, byte[] arqCnh, byte[] comprovanteRs, String cetpp, byte[] arqCetpp, byte[] arqExamTox, byte[] arqAso, String rg) {
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
        this.registrationNumber = registrationNumber;
        this.licenseExpiryDate = licenseExpiryDate;
        this.birthDate = birthDate;
        this.address = address;
        this.cnh = cnh;
        this.arqCnh = arqCnh;
        this.comprovanteRs = comprovanteRs;
        this.cetpp = cetpp;
        this.arqCetpp = arqCetpp;
        this.arqExamTox = arqExamTox;
        this.arqAso = arqAso;
        this.rg = rg;
    }

    // Getters e Setters existentes...

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    // GETTER E SETTER DO NOVO CAMPO
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public byte[] getArqCnh() {
        return arqCnh;
    }

    public void setArqCnh(byte[] arqCnh) {
        this.arqCnh = arqCnh;
    }

    public byte[] getComprovanteRs() {
        return comprovanteRs;
    }

    public void setComprovanteRs(byte[] comprovanteRs) {
        this.comprovanteRs = comprovanteRs;
    }

    public String getCetpp() {
        return cetpp;
    }

    public void setCetpp(String cetpp) {
        this.cetpp = cetpp;
    }

    public byte[] getArqCetpp() {
        return arqCetpp;
    }

    public void setArqCetpp(byte[] arqCetpp) {
        this.arqCetpp = arqCetpp;
    }

    public byte[] getArqExamTox() {
        return arqExamTox;
    }

    public void setArqExamTox(byte[] arqExamTox) {
        this.arqExamTox = arqExamTox;
    }

    public byte[] getArqAso() {
        return arqAso;
    }

    public void setArqAso(byte[] arqAso) {
        this.arqAso = arqAso;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}