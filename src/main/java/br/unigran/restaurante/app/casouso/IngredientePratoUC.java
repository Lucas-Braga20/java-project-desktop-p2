package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredientePratoBuilder;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.persistence.DAO;

public class IngredientePratoUC {
  public IngredientePrato salvar(IngredientePratoBuilder ingredientePratoBuilder) throws Exception {
    IngredientePrato ingredientePrato = ingredientePratoBuilder.build();
    ingredientePrato = new DAO<IngredientePrato>().salvar(ingredientePrato, IngredientePrato.class, ingredientePrato.getId().intValue());

    System.out.println(ingredientePrato.toString());

    return ingredientePrato;
  }

  public IngredientePrato atualizar(IngredientePratoBuilder ingredientePratoBuilder, IngredientePrato ingredientePrato) throws Exception {
    IngredientePrato ingredientePratoAnterior = ingredientePratoBuilder.build(ingredientePrato);
    IngredientePrato ingredientePratoAtualizado = new DAO<IngredientePrato>().salvar(ingredientePratoAnterior, IngredientePrato.class, ingredientePratoAnterior.getId().intValue());

    System.out.println(ingredientePratoAtualizado.toString());

    return ingredientePratoAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<IngredientePrato>().remover(id, IngredientePrato.class);
  }

  public List<IngredientePrato> listarTodos() throws Exception {
    List<IngredientePrato> ingredientePratos = new DAO<IngredientePrato>().listarTodos(IngredientePrato.class);

    for (int i = 0; i < ingredientePratos.size(); i++) {
      System.out.println(ingredientePratos.get(i).toString());
    }

    return ingredientePratos;
  }

  public IngredientePrato consultarPorId(Integer id) throws Exception {
    IngredientePrato ingredientePrato = new DAO<IngredientePrato>().consultarPorId(id, IngredientePrato.class);

    System.out.println(ingredientePrato.toString());

    return ingredientePrato;
  }
}
