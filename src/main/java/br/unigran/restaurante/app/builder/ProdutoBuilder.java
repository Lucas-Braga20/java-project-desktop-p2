package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Produto;

public class ProdutoBuilder {
    private String nome;
    private String descricao;
    private Float valor;

    public ProdutoBuilder(String nome, Float valor) {
        this.nome = nome;
        this.descricao = "";
        this.valor = valor;
    }

    public ProdutoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }
    public ProdutoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
    public ProdutoBuilder valor(Float valor) {
        this.valor = valor;
        return this;
    }

    public void validate() throws Exception {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new Exception("Nome não pode ser vazio.");
        }

        if (nome.length() > 60) {
            throw new Exception("Nome não pode ser maior que 60.");
        }

        if (valor <= 0) {
            throw new Exception("Valor não pode ser negativo ou nulo.");
        }
    }

    public Produto build() throws Exception {
        validate();

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valor);

        return produto;
    }
    public Produto build(Produto produto) throws Exception {
        validate();

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valor);

        return produto;
    }
}
