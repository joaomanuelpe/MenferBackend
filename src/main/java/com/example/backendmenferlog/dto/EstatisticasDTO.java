package com.example.backendmenferlog.dto;

public class EstatisticasDTO {
    private Integer totalAbastecimentos;
    private Double totalDiesel;
    private Double totalArla;
    private Double totalGasto;
    private Double mediaConsumo;
    private Double totalKm;

    public EstatisticasDTO(Integer totalAbastecimentos, Double totalDiesel, Double totalArla,
                           Double totalGasto, Double mediaConsumo, Double totalKm) {
        this.totalAbastecimentos = totalAbastecimentos;
        this.totalDiesel = totalDiesel;
        this.totalArla = totalArla;
        this.totalGasto = totalGasto;
        this.mediaConsumo = mediaConsumo;
        this.totalKm = totalKm;
    }

    public Integer getTotalAbastecimentos() {
        return totalAbastecimentos;
    }

    public void setTotalAbastecimentos(Integer totalAbastecimentos) {
        this.totalAbastecimentos = totalAbastecimentos;
    }

    public Double getTotalDiesel() {
        return totalDiesel;
    }

    public void setTotalDiesel(Double totalDiesel) {
        this.totalDiesel = totalDiesel;
    }

    public Double getTotalArla() {
        return totalArla;
    }

    public void setTotalArla(Double totalArla) {
        this.totalArla = totalArla;
    }

    public Double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(Double totalGasto) {
        this.totalGasto = totalGasto;
    }

    public Double getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(Double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }

    public Double getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(Double totalKm) {
        this.totalKm = totalKm;
    }
}
