package com.example.backendmenferlog.dto;

public class ComissaoMotoristaDTO {
    private Long idComissao;
    private Long idDaViagem;
    private Double vale;        // ✅ CORRETO: vale (não valePedagio)
    private Double comissao;
    private String descricao;

    // Construtores
    public ComissaoMotoristaDTO() {
    }

    public ComissaoMotoristaDTO(Long idComissao, Long idDaViagem, Double vale, Double comissao, String descricao) {
        this.idComissao = idComissao;
        this.idDaViagem = idDaViagem;
        this.vale = vale;
        this.comissao = comissao;
        this.descricao = descricao;
    }

    // Getters e Setters
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

    @Override
    public String toString() {
        return "ComissaoMotoristaDTO{" +
                "idComissao=" + idComissao +
                ", idDaViagem=" + idDaViagem +
                ", vale=" + vale +
                ", comissao=" + comissao +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
