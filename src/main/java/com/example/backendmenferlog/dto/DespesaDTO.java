package com.example.backendmenferlog.dto;

public class DespesaDTO {
    private String dataDespesa;
    private String dataVencimento;
    private Double valor;

    public DespesaDTO(String dataDespesa, String dataVencimento, Double valor) {
        this.dataDespesa = dataDespesa;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public String getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(String dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
