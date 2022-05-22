package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Prato;

public class PratoBuilder {
    private String nome;
    private String descricao;
    private Float valor;

    public PratoBuilder(String nome, Float valor) {
        this.nome = nome;
        this.descricao = "";
        this.valor = valor;
    }
    public PratoBuilder(Prato prato) {
        this.nome = prato.getNome();
        this.descricao = prato.getDescricao();
        this.valor = prato.getValor();
    }

    public PratoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public void validate() throws Exception {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new Exception("Nome não pode ser vazio.");
        }

        if (valor <= 0) {
            throw new Exception("Valor não pode ser negativo ou nulo.");
        }
    }

    public Prato build() throws Exception {
        validate();

        Prato prato = new Prato();
        prato.setNome(nome);
        prato.setDescricao(descricao);
        prato.setValor(valor);

        return prato;
    }
    public Prato build(Prato prato) throws Exception {
        validate();

        prato.setNome(nome);
        prato.setDescricao(descricao);
        prato.setValor(valor);

        return prato;
    }
}
