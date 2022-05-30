package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PapelBuilder;
import br.unigran.restaurante.app.models.Papel;
import br.unigran.restaurante.app.persistence.DAO;

public class PapelUC {
  public Papel salvar(PapelBuilder papelBuilder) throws Exception {
    Papel papel = papelBuilder.build();
    papel = new DAO<Papel>().salvar(papel, Papel.class, papel.getId());

    return papel;
  }

  public Papel atualizar(PapelBuilder papelBuilder, Papel papel) throws Exception {
    Papel papelAnterior = papelBuilder.build(papel);
    Papel papelAtualizado = new DAO<Papel>().salvar(papelAnterior, Papel.class, papelAnterior.getId());

    return papelAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<Papel>().remover(id, Papel.class);
  }

  public List<Papel> listarTodos() throws Exception {
    List<Papel> papeis = new DAO<Papel>().listarTodos(Papel.class);

    return papeis;
  }

  public Papel consultarPorId(Integer id) throws Exception {
    Papel papel = new DAO<Papel>().consultarPorId(id, Papel.class);

    return papel;
  }
}
