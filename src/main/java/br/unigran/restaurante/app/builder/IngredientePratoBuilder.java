package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.enums.UnidadeMedida;
import br.unigran.restaurante.app.models.Ingrediente;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.models.Prato;

public class IngredientePratoBuilder {

    private UnidadeMedida unidadeMedida;
    private Float quantidade;
    private Float valor;
    private Ingrediente ingrediente;
    private Prato prato;

    public IngredientePratoBuilder(Float quantidade, Float valor, Ingrediente ingrediente, Prato prato,
            UnidadeMedida unidadeMedida) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.unidadeMedida = unidadeMedida;
        this.ingrediente = ingrediente;
        this.prato = prato;
    }

    public IngredientePratoBuilder unidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
        return this;
    }

    public IngredientePratoBuilder quantidade(Float quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public IngredientePratoBuilder valor(Float valor) {
        this.valor = valor;
        return this;
    }

    public void validate() throws Exception {
        if (quantidade <= 0) {
            throw new Exception("Quantidade não pode ser negativo ou nulo.");
        }

        if (valor <= 0) {
            throw new Exception("Valor não pode ser negativo ou nulo.");
        }
        
        if (ingrediente == null) {
            throw new Exception("Ingrediente não pode ser nulo.");
        }
        
        if (prato == null) {
            throw new Exception("Prato não pode ser nulo.");
        }
    }

    public IngredientePrato build() throws Exception {
        validate();

        IngredientePrato ingredientePrato = new IngredientePrato();
        ingredientePrato.setQuantidade(quantidade);
        ingredientePrato.setUnidadeMedida(unidadeMedida);
        ingredientePrato.setValor(valor);
        ingredientePrato.setIngrediente(ingrediente);
        ingredientePrato.setPrato(prato);

        return ingredientePrato;
    }
    public IngredientePrato build(IngredientePrato ingredientePrato) throws Exception {
        validate();

        ingredientePrato.setQuantidade(quantidade);
        ingredientePrato.setUnidadeMedida(unidadeMedida);
        ingredientePrato.setValor(valor);
        ingredientePrato.setIngrediente(ingrediente);
        ingredientePrato.setPrato(prato);

        return ingredientePrato;
    }
}
