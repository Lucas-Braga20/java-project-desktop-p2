package br.unigran.restaurante.app.models;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Funcionario extends Usuario {
    @Column(length = 50)
    private String nome;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Column(length = 14)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "cargoId", nullable = false)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "enderecoId")
    private Endereco endereco;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionarioId")
    private List<Pedido> pedidos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
