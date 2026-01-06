package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.Multa;

import java.time.LocalDate;

public class MultaDto {
    private Long idDepesa;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private LocalDate dataDespesa;
    private String descricao;
    private double valor;
    private Multa multa;

    public MultaDto(Long idDepesa, LocalDate dataVencimento, LocalDate dataPagamento, LocalDate dataDespesa, String descricao, double valor, Multa multa) {
        this.idDepesa = idDepesa;
        this.dataDespesa = dataDespesa;
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.valor = valor;
        this.multa = multa;
    }

    public Long getIdDepesa() {
        return idDepesa;
    }

    public void setIdDepesa(Long idDepesa) {
        this.idDepesa = idDepesa;
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

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
