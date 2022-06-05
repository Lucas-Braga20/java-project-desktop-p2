package br.unigran.restaurante.app.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.unigran.restaurante.app.enums.Cidade;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100)
    private String rua;

    @Column(columnDefinition = "INTEGER")
    private Integer numero;

    @Column(length = 100)
    private String bairro;

    @Enumerated(EnumType.ORDINAL)
    private Cidade cidade;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoId")
    List<Cliente> clientes;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoId")
    List<Funcionario> funcionarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return this.bairro + ", " + this.rua + ", " + this.numero + " / " + this.cidade;
    }
}
