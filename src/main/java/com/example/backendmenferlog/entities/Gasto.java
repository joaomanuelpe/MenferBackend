package com.example.backendmenferlog.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "gasto")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idGasto\"")
    private Long idGasto;

    @ManyToOne
    @JoinColumn(name = "\"fornecedorCnpj\"")
    private Fornecedor fornecedor;

    @Column(name = "\"numNotaFisc\"")
    private String numNotaFisc;

    @Column(name = "\"numBoleto\"")
    private String numBoleto;

    @Column(name = "\"qtdParc\"")
    private int qtdParc;

    public Gasto() {
    }

    public Gasto(Long idGasto, Fornecedor fornecedor, String numNotaFisc, String numBoleto, int qtdParc) {
        this.idGasto = idGasto;
        this.fornecedor = fornecedor;
        this.numNotaFisc = numNotaFisc;
        this.numBoleto = numBoleto;
        this.qtdParc = qtdParc;
    }

    public Long getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Long idGasto) {
        this.idGasto = idGasto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNumNotaFisc() {
        return numNotaFisc;
    }

    public void setNumNotaFisc(String numNotaFisc) {
        this.numNotaFisc = numNotaFisc;
    }

    public String getNumBoleto() {
        return numBoleto;
    }

    public void setNumBoleto(String numBoleto) {
        this.numBoleto = numBoleto;
    }

    public int getQtdParc() {
        return qtdParc;
    }

    public void setQtdParc(int qtdParc) {
        this.qtdParc = qtdParc;
    }
}
