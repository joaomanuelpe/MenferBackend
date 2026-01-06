package com.example.backendmenferlog.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idServico\"")
    private Long idServico;

    @ManyToOne
    @JoinColumn(name = "\"veiculoPlaca\"")
    private Veiculo veiculo;

    @Column(name = "\"ordemServico\"")
    private String ordemServico;

    public Servico() {
    }

    public Servico(Long idServico, Veiculo veiculo, String ordemServico) {
        this.idServico = idServico;
        this.veiculo = veiculo;
        this.ordemServico = ordemServico;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(String ordemServico) {
        this.ordemServico = ordemServico;
    }
}
