package br.unigran.restaurante.app.builder;

import java.util.Date;

import br.unigran.restaurante.app.models.Cliente;
import br.unigran.restaurante.app.models.Endereco;

public class ClienteBuilder {
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private Endereco endereco;

    public ClienteBuilder(String nome, Date dataNascimento, String cpf, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void validate() throws Exception {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new Exception("Nome não pode ser vazio.");
        }

        if (cpf.isEmpty() || cpf.isBlank()) {
            throw new Exception("Quantidade não pode ser negativo ou nulo.");
        }
        
        if (dataNascimento == null) {
            throw new Exception("Data de nascimento não pode ser nulo.");
        }
    }

    public Cliente build() throws Exception {
        validate();

        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setDataNascimento(dataNascimento);
        cliente.setNome(nome);
        cliente.setEndereco(endereco);

        return cliente;
    }

    public Cliente build(Cliente cliente) throws Exception {
        validate();

        cliente.setCpf(cpf);
        cliente.setDataNascimento(dataNascimento);
        cliente.setNome(nome);
        cliente.setEndereco(endereco);

        return cliente;
    }
}
