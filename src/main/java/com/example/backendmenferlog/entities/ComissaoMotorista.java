package com.example.backendmenferlog.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comissao_motorista")
public class ComissaoMotorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idComissao\"")
    private Long idComissao;

    @Column(name = "\"idViagem\"", nullable = false)
    private Long idDaViagem;

    @Column(name = "vale")
    private Double vale;

    @Column(name = "comissao")
    private Double comissao;

    @Column(name = "descricao")
    private String descricao;

    public ComissaoMotorista() {
    }

    public ComissaoMotorista(Long idComissao, Long idDaViagem, Double vale, Double comissao, String descricao) {
        this.idComissao = idComissao;
        this.idDaViagem = idDaViagem;
        this.vale = vale;
        this.comissao = comissao;
        this.descricao = descricao;
    }

    public Long getIdComissao() {
        return idComissao;
    }

    public void setIdComissao(Long idComissao) {
        this.idComissao = idComissao;
    }

    public Long getIdDaViagem() {
        return idDaViagem;
    }

    public void setIdDaViagem(Long idDaViagem) {
        this.idDaViagem = idDaViagem;
    }

    public Double getVale() {
        return vale;
    }

    public void setVale(Double vale) {
        this.vale = vale;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}