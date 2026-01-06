package com.example.backendmenferlog.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abastecimento")
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idAbastecimento\"")
    private Long idAbastecimento;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "placa")
    private String placa;

    @Column(name = "\"kmAnterior\"")
    private Double kmAnterior;

    @Column(name = "\"kmPosterior\"")
    private Double kmPosterior;

    @Column(name = "\"kmPercorrido\"")
    private Double kmPercorrido;

    @Column(name = "\"dieselLitros\"")
    private Double dieselLitros;

    @Column(name = "\"mediaKmLitro\"")
    private Double mediaKmLitro;

    @Column(name = "\"precoLitroDiesel\"")
    private Double precoLitroDiesel;

    @Column(name = "\"totalDiesel\"")
    private Double totalDiesel;

    @Column(name = "\"arlaLitros\"")
    private Double arlaLitros;

    @Column(name = "\"precoLitroArla\"")
    private Double precoLitroArla;

    @Column(name = "\"totalArla\"")
    private Double totalArla;

    @Column(name = "total")
    private Double total;

    @Column(name = "observacoes")
    private String observacoes;

    public Abastecimento() {
    }

    public Abastecimento(Long idAbastecimento, LocalDate data, String placa, Double kmAnterior,
                         Double kmPosterior, Double kmPercorrido, Double dieselLitros,
                         Double mediaKmLitro, Double precoLitroDiesel, Double totalDiesel,
                         Double arlaLitros, Double precoLitroArla, Double totalArla,
                         Double total, String observacoes) {
        this.idAbastecimento = idAbastecimento;
        this.data = data;
        this.placa = placa;
        this.kmAnterior = kmAnterior;
        this.kmPosterior = kmPosterior;
        this.kmPercorrido = kmPercorrido;
        this.dieselLitros = dieselLitros;
        this.mediaKmLitro = mediaKmLitro;
        this.precoLitroDiesel = precoLitroDiesel;
        this.totalDiesel = totalDiesel;
        this.arlaLitros = arlaLitros;
        this.precoLitroArla = precoLitroArla;
        this.totalArla = totalArla;
        this.total = total;
        this.observacoes = observacoes;
    }

    public void calcularValores() {
        if (this.kmPosterior != null && this.kmAnterior != null && this.kmPosterior > this.kmAnterior) {
            this.kmPercorrido = this.kmPosterior - this.kmAnterior;
        }

        if (this.dieselLitros != null && this.precoLitroDiesel != null) {
            this.totalDiesel = this.dieselLitros * this.precoLitroDiesel;
        }

        if (this.arlaLitros != null && this.precoLitroArla != null) {
            this.totalArla = this.arlaLitros * this.precoLitroArla;
        }

        if (this.kmPercorrido != null && this.dieselLitros != null &&
                this.kmPercorrido > 0 && this.dieselLitros > 0) {
            this.mediaKmLitro = this.kmPercorrido / this.dieselLitros;
        }

        Double totalDieselCalc = this.totalDiesel != null ? this.totalDiesel : 0.0;
        Double totalArlaCalc = this.totalArla != null ? this.totalArla : 0.0;
        this.total = totalDieselCalc + totalArlaCalc;
    }

    public Long getIdAbastecimento() {
        return idAbastecimento;
    }

    public void setIdAbastecimento(Long idAbastecimento) {
        this.idAbastecimento = idAbastecimento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getKmAnterior() {
        return kmAnterior;
    }

    public void setKmAnterior(Double kmAnterior) {
        this.kmAnterior = kmAnterior;
    }

    public Double getKmPosterior() {
        return kmPosterior;
    }

    public void setKmPosterior(Double kmPosterior) {
        this.kmPosterior = kmPosterior;
    }

    public Double getKmPercorrido() {
        return kmPercorrido;
    }

    public void setKmPercorrido(Double kmPercorrido) {
        this.kmPercorrido = kmPercorrido;
    }

    public Double getDieselLitros() {
        return dieselLitros;
    }

    public void setDieselLitros(Double dieselLitros) {
        this.dieselLitros = dieselLitros;
    }

    public Double getMediaKmLitro() {
        return mediaKmLitro;
    }

    public void setMediaKmLitro(Double mediaKmLitro) {
        this.mediaKmLitro = mediaKmLitro;
    }

    public Double getPrecoLitroDiesel() {
        return precoLitroDiesel;
    }

    public void setPrecoLitroDiesel(Double precoLitroDiesel) {
        this.precoLitroDiesel = precoLitroDiesel;
    }

    public Double getTotalDiesel() {
        return totalDiesel;
    }

    public void setTotalDiesel(Double totalDiesel) {
        this.totalDiesel = totalDiesel;
    }

    public Double getArlaLitros() {
        return arlaLitros;
    }

    public void setArlaLitros(Double arlaLitros) {
        this.arlaLitros = arlaLitros;
    }

    public Double getPrecoLitroArla() {
        return precoLitroArla;
    }

    public void setPrecoLitroArla(Double precoLitroArla) {
        this.precoLitroArla = precoLitroArla;
    }

    public Double getTotalArla() {
        return totalArla;
    }

    public void setTotalArla(Double totalArla) {
        this.totalArla = totalArla;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
