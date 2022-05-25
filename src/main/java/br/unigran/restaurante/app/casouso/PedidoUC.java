package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PedidoBuilder;
import br.unigran.restaurante.app.models.Pedido;
import br.unigran.restaurante.app.persistence.PedidoDAO;

public class PedidoUC {
  public Pedido salvar(PedidoBuilder pedidoBuilder) throws Exception {
    Pedido pedido = new PedidoDAO().salvar(pedidoBuilder.build());

    System.out.println(pedido.toString());

    return pedido;
  }

  public Pedido atualizar(PedidoBuilder pedidoBuilder, Pedido pedido) throws Exception {
    Pedido pedidoAtualizado = new PedidoDAO().salvar(pedidoBuilder.build(pedido));

    System.out.println(pedidoAtualizado.toString());

    return pedidoAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new PedidoDAO().remover(id);
  }

  public List<Pedido> listarTodos() throws Exception {
    List<Pedido> pedidos = new PedidoDAO().listarTodos();

    for (int i = 0; i < pedidos.size(); i++) {
      System.out.println(pedidos.get(i).toString());
    }

    return pedidos;
  }

  public Pedido consultarPorId(Integer id) throws Exception {
    Pedido pedido = new PedidoDAO().consultarPorId(id);

    System.out.println(pedido.toString());

    return pedido;
  }
}
