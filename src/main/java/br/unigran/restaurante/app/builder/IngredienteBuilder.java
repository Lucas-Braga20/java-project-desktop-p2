package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.enums.UnidadeMedida;
import br.unigran.restaurante.app.models.Ingrediente;

public class IngredienteBuilder {
    private String descricao;
    private Float quantidade;
    private UnidadeMedida unidadeMedida;
    private Float valor;

    public IngredienteBuilder(String descricao, UnidadeMedida unidadeMedida, Float valor) {
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.valor = valor;
    }
    public IngredienteBuilder(Ingrediente ingrediente) {
        this.descricao = ingrediente.getDescricao();
        this.unidadeMedida = ingrediente.getUnidadeMedida();
        this.valor = ingrediente.getValor();
    }

    public IngredienteBuilder quantidade(Float quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public void validate() throws Exception {
        if (descricao.isBlank() || descricao.isEmpty()) {
            throw new Exception("Descrição não pode ser vazia.");
        }

        if (quantidade <= 0) {
            throw new Exception("Quantidade não pode ser negativa ou nula.");
        }

        if (valor <= 0) {
            throw new Exception("Valor não pode ser negativo ou nulo.");
        }
    }

    public Ingrediente build() throws Exception {
        validate();

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setDescricao(descricao);
        ingrediente.setQuantidade(quantidade);
        ingrediente.setUnidadeMedida(unidadeMedida);
        ingrediente.setValor(valor);

        return ingrediente;
    }
    public Ingrediente build(Ingrediente ingrediente) throws Exception {
        validate();

        ingrediente.setDescricao(descricao);
        ingrediente.setQuantidade(quantidade);
        ingrediente.setUnidadeMedida(unidadeMedida);
        ingrediente.setValor(valor);

        return ingrediente;
    }
}
