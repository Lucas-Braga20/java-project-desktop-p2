package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PratoPedidoBuilder;
import br.unigran.restaurante.app.models.PratoPedido;
import br.unigran.restaurante.app.persistence.PratoPedidoDAO;

public class PratoPedidoUC {
  public PratoPedido salvar(PratoPedidoBuilder pratoPedidoBuilder) throws Exception {
    PratoPedido pratoPedido = new PratoPedidoDAO().salvar(pratoPedidoBuilder.build());

    System.out.println(pratoPedido.toString());

    return pratoPedido;
  }

  public PratoPedido atualizar(PratoPedidoBuilder pratoPedidoBuilder, PratoPedido pratoPedido) throws Exception {
    PratoPedido pratoPedidoAtualizado = new PratoPedidoDAO().salvar(pratoPedidoBuilder.build(pratoPedido));

    System.out.println(pratoPedidoAtualizado.toString());

    return pratoPedidoAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new PratoPedidoDAO().remover(id);
  }

  public List<PratoPedido> listarTodos() throws Exception {
    List<PratoPedido> pratoPedidos = new PratoPedidoDAO().listarTodos();

    for (int i = 0; i < pratoPedidos.size(); i++) {
      System.out.println(pratoPedidos.get(i).toString());
    }

    return pratoPedidos;
  }

  public PratoPedido consultarPorId(Integer id) throws Exception {
    PratoPedido pratoPedido = new PratoPedidoDAO().consultarPorId(id);

    System.out.println(pratoPedido.toString());

    return pratoPedido;
  }
}
