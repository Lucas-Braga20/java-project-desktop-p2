package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredientePratoBuilder;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.persistence.IngredientePratoDAO;

public class IngredientePratoUC {
  public IngredientePrato salvar(IngredientePratoBuilder ingredientePratoBuilder) throws Exception {
    IngredientePrato ingredientePrato = new IngredientePratoDAO().salvar(ingredientePratoBuilder.build());

    System.out.println(ingredientePrato.toString());

    return ingredientePrato;
  }

  public IngredientePrato atualizar(IngredientePratoBuilder ingredientePratoBuilder, IngredientePrato ingredientePrato)
      throws Exception {
    IngredientePrato ingredientePratoAtualizado = new IngredientePratoDAO()
        .salvar(ingredientePratoBuilder.build(ingredientePrato));

    System.out.println(ingredientePratoAtualizado.toString());

    return ingredientePratoAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new IngredientePratoDAO().remover(id);
  }

  public List<IngredientePrato> listarTodos() throws Exception {
    List<IngredientePrato> ingredientePratos = new IngredientePratoDAO().listarTodos();

    for (int i = 0; i < ingredientePratos.size(); i++) {
      System.out.println(ingredientePratos.get(i).toString());
    }

    return ingredientePratos;
  }

  public IngredientePrato consultarPorId(Integer id) throws Exception {
    IngredientePrato ingredientePrato = new IngredientePratoDAO().consultarPorId(id);

    System.out.println(ingredientePrato.toString());

    return ingredientePrato;
  }
}
