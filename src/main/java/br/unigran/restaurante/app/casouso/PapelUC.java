package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PapelBuilder;
import br.unigran.restaurante.app.models.Papel;
import br.unigran.restaurante.app.persistence.DAO;

public class PapelUC {
  public Papel salvar(PapelBuilder papelBuilder) throws Exception {
    Papel papel = papelBuilder.build();
    papel = new DAO<Papel>().salvar(papel, Papel.class, papel.getId().intValue());

    System.out.println(papel.toString());

    return papel;
  }

  public Papel atualizar(PapelBuilder papelBuilder, Papel papel) throws Exception {
    Papel papelAnterior = papelBuilder.build(papel);
    Papel papelAtualizado = new DAO<Papel>().salvar(papelAnterior, Papel.class, papelAnterior.getId().intValue());

    System.out.println(papelAtualizado.toString());

    return papelAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<Papel>().remover(id, Papel.class);
  }

  public List<Papel> listarTodos() throws Exception {
    List<Papel> papeis = new DAO<Papel>().listarTodos(Papel.class);

    for (int i = 0; i < papeis.size(); i++) {
      System.out.println(papeis.get(i).toString());
    }

    return papeis;
  }

  public Papel consultarPorId(Integer id) throws Exception {
    Papel papel = new DAO<Papel>().consultarPorId(id, Papel.class);

    System.out.println(papel.toString());

    return papel;
  }
}
