package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.Gasto;
import com.example.backendmenferlog.entities.Parcela;

import java.time.LocalDate;

public class ParcelaDto {
    private LocalDate dataDespesa;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private String descricao;
    private Long idDespesa;
    private Parcela parcela;
    private String status;
    private double valor;

    public ParcelaDto(Long idDepesa, LocalDate dataVencimento, LocalDate dataDespesa, LocalDate dataPagamento, String descricao, String status, double valor, Parcela parcela) {
        this.idDespesa = idDepesa;
        this.dataVencimento = dataVencimento;
        this.dataDespesa = dataDespesa;
        this.dataPagamento = dataPagamento;
        this.descricao = descricao;
        this.status = status;
        this.valor = valor;
        this.parcela = parcela;
    }

    public Long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDepesa) {
        this.idDespesa = idDepesa;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(LocalDate dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
