package com.example.backendmenferlog.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @Column(name = "placa")
    private String placa;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "renavam")
    private String renavam;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "chassi")
    private String chassi;

    @Column(name = "licenciamento")
    private LocalDate licenciamento;

    @Column(name = "\"expiraLicenciamento\"")
    private LocalDate expiraLicenciamento;

    @Column(name = "\"anttText\"")
    private String anttText;

    @Column(name = "antt")
    private byte[] antt;

    @Column(name = "\"idRastreador\"")
    private String idRastreador;

    @Column(name = "\"empresaRastreador\"")
    private String empresaRastreador;

    @Column(name = "\"contratoArrendamento\"")
    private byte[] contratoArrendamento;

    @Column(name = "civ")
    private String civ;

    @Column(name = "\"civNumero\"")
    private String civNumero;

    @Column(name = "\"expiraCiv\"")
    private LocalDate expiraCiv;

    @Column(name = "\"arqCrlv\"")
    private byte[] arqCrlv;

    @Column(name = "\"arqCrono\"")
    private byte[] arqCrono;

    @Column(name = "\"arqLaudoOpa\"")
    private byte[] arqLaudoOpa;

    public Veiculo() {
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, String tipo, String renavam, String marca, String modelo, String chassi, LocalDate licenciamento, LocalDate expiraLicenciamento, String anttText, byte[] antt, String idRastreador, String empresaRastreador, byte[] contratoArrendamento, String civ, String civNumero, LocalDate expiraCiv, byte[] arqCrlv, byte[] arqCrono, byte[] arqLaudoOpa) {
        this.placa = placa;
        this.tipo = tipo;
        this.renavam = renavam;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.licenciamento = licenciamento;
        this.expiraLicenciamento = expiraLicenciamento;
        this.anttText = anttText;
        this.antt = antt;
        this.idRastreador = idRastreador;
        this.empresaRastreador = empresaRastreador;
        this.contratoArrendamento = contratoArrendamento;
        this.civ = civ;
        this.civNumero = civNumero;
        this.expiraCiv = expiraCiv;
        this.arqCrlv = arqCrlv;
        this.arqCrono = arqCrono;
        this.arqLaudoOpa = arqLaudoOpa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public LocalDate getLicenciamento() {
        return licenciamento;
    }

    public void setLicenciamento(LocalDate licenciamento) {
        this.licenciamento = licenciamento;
    }

    public LocalDate getExpiraLicenciamento() {
        return expiraLicenciamento;
    }

    public void setExpiraLicenciamento(LocalDate expiraLicenciamento) {
        this.expiraLicenciamento = expiraLicenciamento;
    }

    public String getAnttText() {
        return anttText;
    }

    public void setAnttText(String anttText) {
        this.anttText = anttText;
    }

    public byte[] getAntt() {
        return antt;
    }

    public void setAntt(byte[] antt) {
        this.antt = antt;
    }

    public String getIdRastreador() {
        return idRastreador;
    }

    public void setIdRastreador(String idRastreador) {
        this.idRastreador = idRastreador;
    }

    public String getEmpresaRastreador() {
        return empresaRastreador;
    }

    public void setEmpresaRastreador(String empresaRastreador) {
        this.empresaRastreador = empresaRastreador;
    }

    public byte[] getContratoArrendamento() {
        return contratoArrendamento;
    }

    public void setContratoArrendamento(byte[] contratoArrendamento) {
        this.contratoArrendamento = contratoArrendamento;
    }

    public String getCiv() {
        return civ;
    }

    public void setCiv(String civ) {
        this.civ = civ;
    }

    public String getCivNumero() {
        return civNumero;
    }

    public void setCivNumero(String civNumero) {
        this.civNumero = civNumero;
    }

    public LocalDate getExpiraCiv() {
        return expiraCiv;
    }

    public void setExpiraCiv(LocalDate expiraCiv) {
        this.expiraCiv = expiraCiv;
    }

    public byte[] getArqCrlv() {
        return arqCrlv;
    }

    public void setArqCrlv(byte[] arqCrlv) {
        this.arqCrlv = arqCrlv;
    }

    public byte[] getArqCrono() {
        return arqCrono;
    }

    public void setArqCrono(byte[] arqCrono) {
        this.arqCrono = arqCrono;
    }

    public byte[] getArqLaudoOpa() {
        return arqLaudoOpa;
    }

    public void setArqLaudoOpa(byte[] arqLaudoOpa) {
        this.arqLaudoOpa = arqLaudoOpa;
    }
}