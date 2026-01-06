package com.example.backendmenferlog.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "despesa")
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idDespesa\"")
    private Long idDespesa;

    @Column(name = "\"dataDespesa\"")
    private LocalDate dataDespesa;

    @Column(name = "\"dataVencimento\"")
    private LocalDate dataVencimento;

    @Column(name = "valor")
    private double valor;

    @Column(name = "\"dataPagamento\"")
    private LocalDate dataPagamento;

    @Column(name = "status")
    private String status;

    @Column(name = "\"meioPagamento\"")
    private String meioPagamento;

    @Column(name = "descricao")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "\"idAbastecimento\"")
    private Abastecimento abastecimento;

    @OneToOne
    @JoinColumn(name = "\"idViagem\"")
    private Viagem viagem;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "\"idServico\"")
    private Servico servico;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "\"idMulta\"")
    private Multa multa;

    @OneToOne
    @JoinColumn(name = "\"idParcela\"")
    private Parcela parcela;

    public Despesa() {
    }

    public Despesa(Long idDespesa, LocalDate dataDespesa, LocalDate dataVencimento, double valor, Multa multa, String status, String descricao) {
        this.idDespesa = idDespesa;
        this.dataDespesa = dataDespesa;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.multa = multa;
        this.status = status;
        this.descricao = descricao;
    }

    public Despesa(Long idDespesa, LocalDate dataDespesa, LocalDate dataVencimento, double valor, Servico servico, String status, String descricao) {
        this.idDespesa = idDespesa;
        this.dataDespesa = dataDespesa;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.servico = servico;
        this.status = status;
        this.descricao = descricao;
    }

    public Despesa(Long idDespesa, LocalDate dataDespesa, LocalDate dataVencimento, double valor, Parcela parcela, String status, String descricao) {
        this.idDespesa = idDespesa;
        this.dataDespesa = dataDespesa;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.parcela = parcela;
        this.status = status;
        this.descricao = descricao;
    }

    public Despesa(Long idDespesa, LocalDate dataDespesa, LocalDate dataVencimento, double valor, LocalDate dataPagamento, String status, String meioPagamento, String descricao, Abastecimento abastecimento, Viagem viagem, Servico servico, Multa multa, Parcela parcela) {
        this.idDespesa = idDespesa;
        this.dataDespesa = dataDespesa;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
        this.meioPagamento = meioPagamento;
        this.descricao = descricao;
        this.abastecimento = abastecimento;
        this.viagem = viagem;
        this.servico = servico;
        this.multa = multa;
        this.parcela = parcela;
    }

    public Long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public LocalDate getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(LocalDate dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public String getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(String meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Abastecimento getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(Abastecimento abastecimento) {
        this.abastecimento = abastecimento;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }
}
