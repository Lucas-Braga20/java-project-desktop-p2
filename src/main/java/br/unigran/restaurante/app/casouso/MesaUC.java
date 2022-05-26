package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.MesaBuilder;
import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.persistence.DAO;

public class MesaUC {
  public Mesa salvar(MesaBuilder mesaBuilder) throws Exception {
    Mesa mesa = mesaBuilder.build();
    mesa = new DAO<Mesa>().salvar(mesa, Mesa.class, mesa.getId().intValue());

    System.out.println(mesa.toString());

    return mesa;
  }

  public Mesa atualizar(MesaBuilder mesaBuilder, Mesa mesa) throws Exception {
    Mesa mesaAnterior = mesaBuilder.build(mesa);
    Mesa mesaAtualizado = new DAO<Mesa>().salvar(mesaAnterior, Mesa.class, mesaAnterior.getId().intValue());

    System.out.println(mesaAtualizado.toString());

    return mesaAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<Mesa>().remover(id, Mesa.class);
  }

  public List<Mesa> listarTodos() throws Exception {
    List<Mesa> mesas = new DAO<Mesa>().listarTodos(Mesa.class);

    for (int i = 0; i < mesas.size(); i++) {
      System.out.println(mesas.get(i).toString());
    }

    return mesas;
  }

  public Mesa consultarPorId(Integer id) throws Exception {
    Mesa mesa = new DAO<Mesa>().consultarPorId(id, Mesa.class);

    System.out.println(mesa.toString());

    return mesa;
  }
}
