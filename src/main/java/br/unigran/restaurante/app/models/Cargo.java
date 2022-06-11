package br.unigran.restaurante.app.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(unique=true)
    private Integer numero;

    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargoId")
    private List<CargoPapel> cargoPapeis;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<CargoPapel> getCargoPapeis() {
        return cargoPapeis;
    }

    public void setCargoPapeis(List<CargoPapel> cargoPapeis) {
        this.cargoPapeis = cargoPapeis;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
