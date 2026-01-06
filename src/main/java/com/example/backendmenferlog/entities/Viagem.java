package com.example.backendmenferlog.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "viagem")
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idViagem\"")
    private Long idViagem;

    @Column(name = "empresa", length = 45)
    private String empresa;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "cte", length = 30)
    private String cte;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "\"numContainer\"", length = 45)
    private String numContainer;

    @Column(name = "\"tamContainer\"")
    private Double tamContainer;

    @Column(name = "\"tipoContainer\"", length = 45)
    private String tipoContainer;

    @Column(name = "\"placaCavalo\"", length = 45)
    private String placaCavalo;

    @Column(name = "\"placaReboque\"", length = 45)
    private String placaReboque;

    @Column(name = "motorista", length = 45)
    private String motorista;

    @Column(name = "origem", length = 45)
    private String origem;

    @Column(name = "destino", length = 45)
    private String destino;

    @Column(name = "entrega")
    private LocalDate entrega;

    @Column(name = "\"horaDeChegada\"")
    private LocalTime horaDeChegada;

    @Column(name = "\"horaDeSaida\"")
    private LocalTime horaDeSaida;

    @Column(name = "\"tipoDeOperacao\"", length = 20)
    private String tipoDeOperacao;

    @Column(name = "\"valePedagio\"")
    private Boolean valePedagio;

    @Column(name = "\"valorPedagio\"")
    private Double valorPedagio;

    @Column(name = "adiantamento")
    private Double adiantamento;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "\"antecipacaoTerm\"")
    private Boolean antecipacaoTerm;

    @Column(name = "\"valorTerminal\"")
    private Double valorTerminal;

    @Column(name = "estadia")
    private Boolean estadia;

    @Column(name = "\"valorEstadia\"")
    private Double valorEstadia;

    @Column(name = "\"numeroFatur\"")
    private String numeroFatur;

    @Column(name = "\"diaPgto\"")
    private LocalDate diaPgto;

    @Column(name = "status", length = 10)
    private String status;

    public Viagem() {
    }

    public Viagem(Long idViagem, String empresa, LocalDate data, String cte, Double peso,
                  String numContainer, Double tamContainer, String tipoContainer,
                  String placaCavalo, String placaReboque, String motorista, String origem,
                  String destino, LocalDate entrega, LocalTime horaDeChegada, LocalTime horaDeSaida,
                  String tipoDeOperacao, Boolean valePedagio, Double valorPedagio,
                  Double adiantamento, Double saldo, Boolean antecipacaoTerm, Double valorTerminal,
                  Boolean estadia, Double valorEstadia, String numeroFatur, LocalDate diaPgto,
                  String status) {
        this.idViagem = idViagem;
        this.empresa = empresa;
        this.data = data;
        this.cte = cte;
        this.peso = peso;
        this.numContainer = numContainer;
        this.tamContainer = tamContainer;
        this.tipoContainer = tipoContainer;
        this.placaCavalo = placaCavalo;
        this.placaReboque = placaReboque;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.entrega = entrega;
        this.horaDeChegada = horaDeChegada;
        this.horaDeSaida = horaDeSaida;
        this.tipoDeOperacao = tipoDeOperacao;
        this.valePedagio = valePedagio;
        this.valorPedagio = valorPedagio;
        this.adiantamento = adiantamento;
        this.saldo = saldo;
        this.antecipacaoTerm = antecipacaoTerm;
        this.valorTerminal = valorTerminal;
        this.estadia = estadia;
        this.valorEstadia = valorEstadia;
        this.numeroFatur = numeroFatur;
        this.diaPgto = diaPgto;
        this.status = status;
    }

    public Long getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(Long idViagem) {
        this.idViagem = idViagem;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCte() {
        return cte;
    }

    public void setCte(String cte) {
        this.cte = cte;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNumContainer() {
        return numContainer;
    }

    public void setNumContainer(String numContainer) {
        this.numContainer = numContainer;
    }

    public Double getTamContainer() {
        return tamContainer;
    }

    public void setTamContainer(Double tamContainer) {
        this.tamContainer = tamContainer;
    }

    public String getTipoContainer() {
        return tipoContainer;
    }

    public void setTipoContainer(String tipoContainer) {
        this.tipoContainer = tipoContainer;
    }

    public String getPlacaCavalo() {
        return placaCavalo;
    }

    public void setPlacaCavalo(String placaCavalo) {
        this.placaCavalo = placaCavalo;
    }

    public String getPlacaReboque() {
        return placaReboque;
    }

    public void setPlacaReboque(String placaReboque) {
        this.placaReboque = placaReboque;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getEntrega() {
        return entrega;
    }

    public void setEntrega(LocalDate entrega) {
        this.entrega = entrega;
    }

    public LocalTime getHoraDeChegada() {
        return horaDeChegada;
    }

    public void setHoraDeChegada(LocalTime horaDeChegada) {
        this.horaDeChegada = horaDeChegada;
    }

    public LocalTime getHoraDeSaida() {
        return horaDeSaida;
    }

    public void setHoraDeSaida(LocalTime horaDeSaida) {
        this.horaDeSaida = horaDeSaida;
    }

    public String getTipoDeOperacao() {
        return tipoDeOperacao;
    }

    public void setTipoDeOperacao(String tipoDeOperacao) {
        this.tipoDeOperacao = tipoDeOperacao;
    }

    public Boolean getValePedagio() {
        return valePedagio;
    }

    public void setValePedagio(Boolean valePedagio) {
        this.valePedagio = valePedagio;
    }

    public Double getValorPedagio() {
        return valorPedagio;
    }

    public void setValorPedagio(Double valorPedagio) {
        this.valorPedagio = valorPedagio;
    }

    public Double getAdiantamento() {
        return adiantamento;
    }

    public void setAdiantamento(Double adiantamento) {
        this.adiantamento = adiantamento;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getAntecipacaoTerm() {
        return antecipacaoTerm;
    }

    public void setAntecipacaoTerm(Boolean antecipacaoTerm) {
        this.antecipacaoTerm = antecipacaoTerm;
    }

    public Double getValorTerminal() {
        return valorTerminal;
    }

    public void setValorTerminal(Double valorTerminal) {
        this.valorTerminal = valorTerminal;
    }

    public Boolean getEstadia() {
        return estadia;
    }

    public void setEstadia(Boolean estadia) {
        this.estadia = estadia;
    }

    public Double getValorEstadia() {
        return valorEstadia;
    }

    public void setValorEstadia(Double valorEstadia) {
        this.valorEstadia = valorEstadia;
    }

    public String getNumeroFatur() {
        return numeroFatur;
    }

    public void setNumeroFatur(String numeroFatur) {
        this.numeroFatur = numeroFatur;
    }

    public LocalDate getDiaPgto() {
        return diaPgto;
    }

    public void setDiaPgto(LocalDate diaPgto) {
        this.diaPgto = diaPgto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}