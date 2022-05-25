package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.CargoPapelBuilder;
import br.unigran.restaurante.app.models.CargoPapel;
import br.unigran.restaurante.app.persistence.CargoPapelDAO;

public class CargoPapelUC {
  public CargoPapel salvar(CargoPapelBuilder cargoPapelBuilder) throws Exception {
    CargoPapel cargoPapel = new CargoPapelDAO().salvar(cargoPapelBuilder.build());

    System.out.println(cargoPapel.toString());

    return cargoPapel;
  }

  public CargoPapel atualizar(CargoPapelBuilder cargoPapelBuilder, CargoPapel cargoPapel) throws Exception {
    CargoPapel cargoPapelAtualizado = new CargoPapelDAO().salvar(cargoPapelBuilder.build(cargoPapel));

    System.out.println(cargoPapelAtualizado.toString());

    return cargoPapelAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new CargoPapelDAO().remover(id);
  }

  public List<CargoPapel> listarTodos() throws Exception {
    List<CargoPapel> cargoPapels = new CargoPapelDAO().listarTodos();

    for (int i = 0; i < cargoPapels.size(); i++) {
      System.out.println(cargoPapels.get(i).toString());
    }

    return cargoPapels;
  }

  public CargoPapel consultarPorId(Integer id) throws Exception {
    CargoPapel cargoPapel = new CargoPapelDAO().consultarPorId(id);

    System.out.println(cargoPapel.toString());

    return cargoPapel;
  }
}
