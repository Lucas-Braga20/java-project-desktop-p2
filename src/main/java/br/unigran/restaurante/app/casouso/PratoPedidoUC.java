package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PratoPedidoBuilder;
import br.unigran.restaurante.app.models.PratoPedido;
import br.unigran.restaurante.app.persistence.DAO;

public class PratoPedidoUC {
  public PratoPedido salvar(PratoPedidoBuilder pratoPedidoBuilder) throws Exception {
    PratoPedido pratoPedido = pratoPedidoBuilder.build();
    pratoPedido = new DAO<PratoPedido>().salvar(pratoPedido, PratoPedido.class, pratoPedido.getId().intValue());

    System.out.println(pratoPedido.toString());

    return pratoPedido;
  }

  public PratoPedido atualizar(PratoPedidoBuilder pratoPedidoBuilder, PratoPedido pratoPedido) throws Exception {
    PratoPedido pratoPedidoAnterior = pratoPedidoBuilder.build(pratoPedido);
    PratoPedido pratoPedidoAtualizado = new DAO<PratoPedido>().salvar(pratoPedidoAnterior, PratoPedido.class, pratoPedidoAnterior.getId().intValue());

    System.out.println(pratoPedidoAtualizado.toString());

    return pratoPedidoAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<PratoPedido>().remover(id, PratoPedido.class);
  }

  public List<PratoPedido> listarTodos() throws Exception {
    List<PratoPedido> pratoPedidos = new DAO<PratoPedido>().listarTodos(PratoPedido.class);

    for (int i = 0; i < pratoPedidos.size(); i++) {
      System.out.println(pratoPedidos.get(i).toString());
    }

    return pratoPedidos;
  }

  public PratoPedido consultarPorId(Integer id) throws Exception {
    PratoPedido pratoPedido = new DAO<PratoPedido>().consultarPorId(id, PratoPedido.class);

    System.out.println(pratoPedido.toString());

    return pratoPedido;
  }
}
