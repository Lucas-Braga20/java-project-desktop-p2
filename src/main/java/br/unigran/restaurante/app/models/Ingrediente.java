package br.unigran.restaurante.app.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.unigran.restaurante.app.enums.UnidadeMedida;

@Entity
public class Ingrediente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(scale = 5, precision = 5)
    private Float quantidade;

    @Enumerated(EnumType.ORDINAL)
    private UnidadeMedida unidade_medida;

    @Column(scale = 9, precision = 2)
    private Float valor;

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnidadeMedida getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(UnidadeMedida unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
}
