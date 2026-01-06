package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.ComissaoMotorista;

public class ComissaoMotoristaResponseDTO {
    private Long idComissao;
    private Long idDaViagem;
    private Double vale;
    private Double comissao;
    private String descricao;

    public ComissaoMotoristaResponseDTO() {
    }

    public ComissaoMotoristaResponseDTO(ComissaoMotorista comissaoMotorista) {
        this.idComissao = comissaoMotorista.getIdComissao();
        this.idDaViagem = comissaoMotorista.getIdDaViagem();
        this.vale = comissaoMotorista.getVale();
        this.comissao = comissaoMotorista.getComissao();
        this.descricao = comissaoMotorista.getDescricao();
    }

    public ComissaoMotoristaResponseDTO(Long idComissao, Long idDaViagem, Double vale, Double comissao, String descricao) {
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