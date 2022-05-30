package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredientePratoBuilder;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.persistence.DAO;

public class IngredientePratoUC {
  public IngredientePrato salvar(IngredientePratoBuilder ingredientePratoBuilder) throws Exception {
    IngredientePrato ingredientePrato = ingredientePratoBuilder.build();
    ingredientePrato = new DAO<IngredientePrato>().salvar(ingredientePrato, IngredientePrato.class, ingredientePrato.getId());

    return ingredientePrato;
  }

  public IngredientePrato atualizar(IngredientePratoBuilder ingredientePratoBuilder, IngredientePrato ingredientePrato) throws Exception {
    IngredientePrato ingredientePratoAnterior = ingredientePratoBuilder.build(ingredientePrato);
    IngredientePrato ingredientePratoAtualizado = new DAO<IngredientePrato>().salvar(ingredientePratoAnterior, IngredientePrato.class, ingredientePratoAnterior.getId());

    return ingredientePratoAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<IngredientePrato>().remover(id, IngredientePrato.class);
  }

  public List<IngredientePrato> listarTodos() throws Exception {
    List<IngredientePrato> ingredientePratos = new DAO<IngredientePrato>().listarTodos(IngredientePrato.class);

    return ingredientePratos;
  }

  public IngredientePrato consultarPorId(Integer id) throws Exception {
    IngredientePrato ingredientePrato = new DAO<IngredientePrato>().consultarPorId(id, IngredientePrato.class);

    return ingredientePrato;
  }
}
