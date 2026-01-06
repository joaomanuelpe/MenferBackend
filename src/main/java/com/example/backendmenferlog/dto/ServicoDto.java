package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.Multa;
import com.example.backendmenferlog.entities.Servico;

import java.time.LocalDate;

public class ServicoDto {
    private Long idDespesa;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private LocalDate dataDespesa;
    private String descricao;
    private double valor;
    private Servico servico;

    public ServicoDto(Long idDespesa, LocalDate dataVencimento, LocalDate dataPagamento, LocalDate dataDespesa, String descricao, double valor, Servico servico) {
        this.idDespesa = idDespesa;
        this.dataDespesa = dataDespesa;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.descricao = descricao;
        this.valor = valor;
        this.servico = servico;
    }

    public Long getIdDepesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
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

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Long getIdDespesa() {
        return idDespesa;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
