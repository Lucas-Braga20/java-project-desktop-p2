package br.unigran.restaurante.app.builder;

import java.util.Date;

import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.Endereco;
import br.unigran.restaurante.app.models.Funcionario;

public class FuncionarioBuilder {

    private String nome;
    private Date dataNascimento;
    private String cpf;
    private Cargo cargo;
    private Endereco endereco;
    private String apelido;
    private String senha;

    public FuncionarioBuilder(String nome, Date dataNascimento, String cpf, Cargo cargo, Endereco endereco,
            String apelido, String senha) {
        this.nome = nome;
        this.apelido = apelido;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.cargo = cargo;
        this.endereco = endereco;
    }

    public FuncionarioBuilder unidadeMedida(String nome) {
        this.nome = nome;
        return this;
    }

    public FuncionarioBuilder quantidade(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public FuncionarioBuilder valor(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public void validate() throws Exception {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new Exception("Nome não pode ser vazio.");
        }

        if (apelido.isEmpty() || apelido.isBlank()) {
            throw new Exception("Apelido não pode ser vazio.");
        }

        if (cpf.isEmpty() || cpf.isBlank()) {
            throw new Exception("CPF não pode vazio.");
        }
        
        if (senha == null) {
            throw new Exception("Senha não pode ser nula.");
        }
        
        if (dataNascimento == null) {
            throw new Exception("Data de nascimento não pode ser nulo.");
        }
        
        if (cargo == null) {
            throw new Exception("Cargo não pode ser nulo.");
        }
    }

    public Funcionario build() throws Exception {
        validate();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setApelido(apelido);
        funcionario.setSenha(senha);
        funcionario.setCpf(cpf);
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);

        return funcionario;
    }
    public Funcionario build(Funcionario funcionario) throws Exception {
        validate();

        funcionario.setNome(nome);
        funcionario.setApelido(apelido);
        funcionario.setSenha(senha);
        funcionario.setCpf(cpf);
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);

        return funcionario;
    }
}
