package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PapelBuilder;
import br.unigran.restaurante.app.models.Papel;
import br.unigran.restaurante.app.persistence.PapelDAO;

public class PapelUC {
  public Papel salvar(PapelBuilder papelBuilder) throws Exception {
    Papel papel = new PapelDAO().salvar(papelBuilder.build());

    System.out.println(papel.toString());

    return papel;
  }

  public Papel atualizar(PapelBuilder papelBuilder, Papel papel) throws Exception {
    Papel papelAtualizado = new PapelDAO().salvar(papelBuilder.build(papel));

    System.out.println(papelAtualizado.toString());

    return papelAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new PapelDAO().remover(id);
  }

  public List<Papel> listarTodos() throws Exception {
    List<Papel> papels = new PapelDAO().listarTodos();

    for (int i = 0; i < papels.size(); i++) {
      System.out.println(papels.get(i).toString());
    }

    return papels;
  }

  public Papel consultarPorId(Integer id) throws Exception {
    Papel papel = new PapelDAO().consultarPorId(id);

    System.out.println(papel.toString());

    return papel;
  }
}
