package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.CargoPapelBuilder;
import br.unigran.restaurante.app.models.CargoPapel;
import br.unigran.restaurante.app.persistence.DAO;

public class CargoPapelUC {
  public CargoPapel salvar(CargoPapelBuilder cargoPapelBuilder) throws Exception {
    CargoPapel cargoPapel = cargoPapelBuilder.build();
    cargoPapel = new DAO<CargoPapel>().salvar(cargoPapel, CargoPapel.class, cargoPapel.getId());

    return cargoPapel;
  }

  public CargoPapel atualizar(CargoPapelBuilder cargoPapelBuilder, CargoPapel cargoPapel) throws Exception {
    CargoPapel cargoPapelAnterior = cargoPapelBuilder.build(cargoPapel);
    CargoPapel cargoPapelAtualizado = new DAO<CargoPapel>().salvar(cargoPapelAnterior, CargoPapel.class, cargoPapelAnterior.getId());

    return cargoPapelAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<CargoPapel>().remover(id, CargoPapel.class);
  }

  public List<CargoPapel> listarTodos() throws Exception {
    List<CargoPapel> cargoPapeis = new DAO<CargoPapel>().listarTodos(CargoPapel.class);

    return cargoPapeis;
  }

  public CargoPapel consultarPorId(Integer id) throws Exception {
    CargoPapel cargoPapel = new DAO<CargoPapel>().consultarPorId(id, CargoPapel.class);

    return cargoPapel;
  }
}
