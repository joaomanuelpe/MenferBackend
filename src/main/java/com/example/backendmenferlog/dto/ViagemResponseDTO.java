package com.example.backendmenferlog.dto;

import com.example.backendmenferlog.entities.Viagem;
import java.time.LocalDate;
import java.time.LocalTime;

public class ViagemResponseDTO {
    private Long idViagem;
    private String empresa;
    private LocalDate data;
    private String cte;
    private Double peso;
    private String numContainer;
    private Double tamContainer;
    private String tipoContainer;
    private String placaCavalo;
    private String placaReboque;
    private String motorista;
    private String origem;
    private String destino;
    private LocalDate entrega;
    private LocalTime horaDeChegada;
    private LocalTime horaDeSaida;
    private String tipoDeOperacao;
    private Boolean valePedagio;
    private Double valorPedagio;
    private Double adiantamento;
    private Double saldo;
    private Boolean antecipacaoTerm;
    private Double valorTerminal;
    private Boolean estadia;
    private Double valorEstadia;
    private String numeroFatur;
    private LocalDate diaPgto;
    private String status;

    public ViagemResponseDTO() {
    }

    public ViagemResponseDTO(Viagem viagem) {
        this.idViagem = viagem.getIdViagem();
        this.empresa = viagem.getEmpresa();
        this.data = viagem.getData();
        this.cte = viagem.getCte();
        this.peso = viagem.getPeso();
        this.numContainer = viagem.getNumContainer();
        this.tamContainer = viagem.getTamContainer();
        this.tipoContainer = viagem.getTipoContainer();
        this.placaCavalo = viagem.getPlacaCavalo();
        this.placaReboque = viagem.getPlacaReboque();
        this.motorista = viagem.getMotorista();
        this.origem = viagem.getOrigem();
        this.destino = viagem.getDestino();
        this.entrega = viagem.getEntrega();
        this.horaDeChegada = viagem.getHoraDeChegada();
        this.horaDeSaida = viagem.getHoraDeSaida();
        this.tipoDeOperacao = viagem.getTipoDeOperacao();
        this.valePedagio = viagem.getValePedagio();
        this.valorPedagio = viagem.getValorPedagio();
        this.adiantamento = viagem.getAdiantamento();
        this.saldo = viagem.getSaldo();
        this.antecipacaoTerm = viagem.getAntecipacaoTerm();
        this.valorTerminal = viagem.getValorTerminal();
        this.estadia = viagem.getEstadia();
        this.valorEstadia = viagem.getValorEstadia();
        this.numeroFatur = viagem.getNumeroFatur();
        this.diaPgto = viagem.getDiaPgto();
        this.status = viagem.getStatus();
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