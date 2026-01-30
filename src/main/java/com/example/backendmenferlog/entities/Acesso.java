package com.example.backendmenferlog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "acesso")
public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idAcesso\"")
    private Long idAcesso;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "\"cardCadastro\"")
    private boolean cardCadastro;

    @Column(name = "\"cardFinanceiro\"")
    private boolean cardFinanceiro;

    @Column(name = "\"cardViagem\"")
    private boolean cardViagem;

    @Column(name = "\"cardAbastecimento\"")
    private boolean cardAbastecimento;

    @Column(name = "\"cardDocumento\"")
    private boolean cardDocumento;

    @Column(name = "\"cardFechamento\"")
    private boolean cardFechamento;

    public Acesso() {
    }

    public Acesso(Long idAcesso, String tipo, boolean cardCadastro, boolean cardFinanceiro, boolean cardViagem, boolean cardAbastecimento, boolean cardDocumento, boolean cardFechamento) {
        this.idAcesso = idAcesso;
        this.tipo = tipo;
        this.cardCadastro = cardCadastro;
        this.cardFinanceiro = cardFinanceiro;
        this.cardViagem = cardViagem;
        this.cardAbastecimento = cardAbastecimento;
        this.cardDocumento = cardDocumento;
        this.cardFechamento = cardFechamento;
    }

    public Long getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(Long idAcesso) {
        this.idAcesso = idAcesso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isCardCadastro() {
        return cardCadastro;
    }

    public void setCardCadastro(boolean cardCadastro) {
        this.cardCadastro = cardCadastro;
    }

    public boolean isCardFinanceiro() {
        return cardFinanceiro;
    }

    public void setCardFinanceiro(boolean cardFinanceiro) {
        this.cardFinanceiro = cardFinanceiro;
    }

    public boolean isCardViagem() {
        return cardViagem;
    }

    public void setCardViagem(boolean cardViagem) {
        this.cardViagem = cardViagem;
    }

    public boolean isCardAbastecimento() {
        return cardAbastecimento;
    }

    public void setCardAbastecimento(boolean cardAbastecimento) {
        this.cardAbastecimento = cardAbastecimento;
    }

    public boolean isCardDocumento() {
        return cardDocumento;
    }

    public void setCardDocumento(boolean cardDocumento) {
        this.cardDocumento = cardDocumento;
    }

    public boolean isCardFechamento() {
        return cardFechamento;
    }

    public void setCardFechamento(boolean cardFechamento) {
        this.cardFechamento = cardFechamento;
    }
}
