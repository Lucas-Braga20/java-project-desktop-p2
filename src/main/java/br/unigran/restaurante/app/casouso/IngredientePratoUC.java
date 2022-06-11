package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredientePratoBuilder;
import br.unigran.restaurante.app.enums.UnidadeMedida;
import br.unigran.restaurante.app.models.Ingrediente;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.models.Prato;
import br.unigran.restaurante.app.persistence.DAO;

public final class IngredientePratoUC {
    private static DAO<IngredientePrato> DAO = new DAO<IngredientePrato>();
    
    public static IngredientePrato salvar(IngredientePratoBuilder ingredientePratoBuilder) throws Exception {
        IngredientePrato ingredientePrato = ingredientePratoBuilder.build();
        ingredientePrato = DAO.salvar(ingredientePrato, IngredientePrato.class, ingredientePrato.getId());
        return ingredientePrato;
    }

    public static IngredientePrato atualizar(IngredientePratoBuilder ingredientePratoBuilder, IngredientePrato ingredientePrato) throws Exception {
        IngredientePrato ingredientePratoAnterior = ingredientePratoBuilder.build(ingredientePrato);
        IngredientePrato ingredientePratoAtualizado = DAO.salvar(ingredientePratoAnterior, IngredientePrato.class, ingredientePratoAnterior.getId());
        return ingredientePratoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, IngredientePrato.class);
    }

    public static List<IngredientePrato> listarTodos() throws Exception {
        List<IngredientePrato> ingredientePratos = DAO.listarTodos(IngredientePrato.class);
        return ingredientePratos;
    }

    public static IngredientePrato consultarPorId(Integer id) throws Exception {
        IngredientePrato ingredientePrato = DAO.consultarPorId(id, IngredientePrato.class);
        return ingredientePrato;
    }
}
