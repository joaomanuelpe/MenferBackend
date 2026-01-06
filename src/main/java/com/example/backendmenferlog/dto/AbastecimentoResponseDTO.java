package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.Abastecimento;
import com.example.backendmenferlog.entities.Despesa;

import java.time.LocalDate;

public class AbastecimentoResponseDTO {
    private Long id;
    private LocalDate data;
    private String placa;
    private Double kmAnterior;
    private Double kmPosterior;
    private Double kmPercorrido;
    private Double dieselLitros;
    private Double mediaKmLitro;
    private Double precoLitroDiesel;
    private Double totalDiesel;
    private Double arlaLitros;
    private Double precoLitroArla;
    private Double totalArla;
    private Double total;
    private String observacoes;

    public AbastecimentoResponseDTO(Abastecimento abastecimento) {
        this.id = abastecimento.getIdAbastecimento();
        this.data = abastecimento.getData();
        this.placa = abastecimento.getPlaca();
        this.kmAnterior = abastecimento.getKmAnterior();
        this.kmPosterior = abastecimento.getKmPosterior();
        this.kmPercorrido = abastecimento.getKmPercorrido();
        this.dieselLitros = abastecimento.getDieselLitros();
        this.mediaKmLitro = abastecimento.getMediaKmLitro();
        this.precoLitroDiesel = abastecimento.getPrecoLitroDiesel();
        this.totalDiesel = abastecimento.getTotalDiesel();
        this.arlaLitros = abastecimento.getArlaLitros();
        this.precoLitroArla = abastecimento.getPrecoLitroArla();
        this.totalArla = abastecimento.getTotalArla();
        this.total = abastecimento.getTotal();
        this.observacoes = abastecimento.getObservacoes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
