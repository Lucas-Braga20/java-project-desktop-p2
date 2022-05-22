package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.enums.Cidade;
import br.unigran.restaurante.app.models.Endereco;

public class EnderecoBuilder {
    private String rua;
    private Integer numero;
    private String bairro;
    private Cidade cidade;

    public EnderecoBuilder(String rua, Integer numero, String bairro, Cidade cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    public EnderecoBuilder(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
    }

    public void validate() throws Exception {
        if (rua.isBlank() || rua.isEmpty()) {
            throw new Exception("Rua não pode ser vazia.");
        }
        if (rua.length() > 100) {
            throw new Exception("Rua não pode ser maior que 100 caracteres.");
        }

        if (numero == null) {
            throw new Exception("Número não pode ser nulo.");
        }

        if (bairro.isBlank() || bairro.isEmpty()) {
            throw new Exception("Bairro não pode ser vazio.");
        }
        if (bairro.length() > 100) {
            throw new Exception("Bairro não pode ser maior que 100 caracteres.");
        }

        if (cidade == null) {
            throw new Exception("Cidade não pode ser nula.");
        }
    }

    public Endereco build() throws Exception {
        validate();

        Endereco endereco = new Endereco();
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setNumero(numero);
        endereco.setRua(rua);

        return endereco;
    }
    public Endereco build(Endereco endereco) throws Exception {
        validate();

        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setNumero(numero);
        endereco.setRua(rua);

        return endereco;
    }
}
