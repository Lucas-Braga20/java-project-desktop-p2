package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.MesaBuilder;
import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.persistence.DAO;
import br.unigran.restaurante.app.persistence.MesaDAO;

public class MesaUC {
  public Mesa salvar(MesaBuilder mesaBuilder) throws Exception {
    Mesa mesa = mesaBuilder.build();
    mesa = new DAO<Mesa>().salvar(mesa, Mesa.class, mesa.getId());

    return mesa;
  }

  public Mesa atualizar(MesaBuilder mesaBuilder, Mesa mesa) throws Exception {
    Mesa mesaAnterior = mesaBuilder.build(mesa);
    Mesa mesaAtualizado = new DAO<Mesa>().salvar(mesaAnterior, Mesa.class, mesaAnterior.getId().intValue());

    return mesaAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<Mesa>().remover(id, Mesa.class);
  }
  
  public void OcuparMesa(Integer id) throws Exception {
      new MesaDAO().ocuparMesa(id);
  }
  
  public void DesocuparMesa(Integer id) throws Exception {
      new MesaDAO().desocuparMesa(id);
  }

  public List<Mesa> listarTodos() throws Exception {
    List<Mesa> mesas = new DAO<Mesa>().listarTodos(Mesa.class);

    return mesas;
  }

  public Mesa consultarPorId(Integer id) throws Exception {
    Mesa mesa = new DAO<Mesa>().consultarPorId(id, Mesa.class);

    return mesa;
  }
}
