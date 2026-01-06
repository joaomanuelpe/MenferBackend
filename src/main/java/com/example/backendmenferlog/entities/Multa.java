package com.example.backendmenferlog.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "multa")
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idMulta\"")
    private Long idMulta;

    @ManyToOne
    @JoinColumn(name = "\"motoristaCpf\"")
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "\"veiculoPlaca\"")
    private Veiculo veiculo;

    @Column(name = "\"numAutoInfracao\"")
    private String numAutoInfracao;

    @Column(name = "\"orgaoAutuador\"")
    private String orgaoAutuador;

    public Multa() {
    }

    public Multa(Long idMulta, Motorista motorista, Veiculo veiculo, String numAutoInfracao, String orgaoAutuador) {
        this.idMulta = idMulta;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.numAutoInfracao = numAutoInfracao;
        this.orgaoAutuador = orgaoAutuador;
    }

    public Long getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Long idMulta) {
        this.idMulta = idMulta;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getNumAutoInfracao() {
        return numAutoInfracao;
    }

    public void setNumAutoInfracao(String numAutoInfracao) {
        this.numAutoInfracao = numAutoInfracao;
    }

    public String getOrgaoAutuador() {
        return orgaoAutuador;
    }

    public void setOrgaoAutuador(String orgaoAutuador) {
        this.orgaoAutuador = orgaoAutuador;
    }
}
