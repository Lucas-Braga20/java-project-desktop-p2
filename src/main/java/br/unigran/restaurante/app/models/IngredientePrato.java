package br.unigran.restaurante.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.unigran.restaurante.app.enums.UnidadeMedida;
import javax.persistence.Column;

@Entity
public class IngredientePrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(scale = 9, precision = 2)
    private Float valor;

    @Enumerated(EnumType.ORDINAL)
    private UnidadeMedida unidadeMedida;

    @Column(scale = 5, precision = 5)
    private Float quantidade;

    @ManyToOne
    @JoinColumn(name = "ingrediteId", nullable = false)
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "pratoId", nullable = false)
    private Prato prato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
}
