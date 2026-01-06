package com.example.backendmenferlog.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "parcela")
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idParcela\"")
    private Long idParcela;

    @Column(name = "\"numParc\"")
    private int numParc;

    @ManyToOne
    @JoinColumn(name = "\"idGasto\"")
    private Gasto gasto;

    public Parcela() {

    }

    public Parcela(Long idParcela, int numParc, Gasto gasto) {
        this.idParcela = idParcela;
        this.numParc = numParc;
        this.gasto = gasto;
    }

    public Long getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(Long idParcela) {
        this.idParcela = idParcela;
    }

    public int getNumParc() {
        return numParc;
    }

    public void setNumParc(int numParc) {
        this.numParc = numParc;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }
}
