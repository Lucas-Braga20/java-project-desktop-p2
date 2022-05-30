package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PedidoBuilder;
import br.unigran.restaurante.app.models.Pedido;
import br.unigran.restaurante.app.persistence.DAO;

public class PedidoUC {
  public Pedido salvar(PedidoBuilder pedidoBuilder) throws Exception {
    Pedido pedido = pedidoBuilder.build();
    pedido = new DAO<Pedido>().salvar(pedido, Pedido.class, pedido.getId());

    return pedido;
  }

  public Pedido atualizar(PedidoBuilder pedidoBuilder, Pedido pedido) throws Exception {
    Pedido pedidoAnterior = pedidoBuilder.build(pedido);
    Pedido pedidoAtualizado = new DAO<Pedido>().salvar(pedidoAnterior, Pedido.class, pedidoAnterior.getId());

    return pedidoAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<Pedido>().remover(id, Pedido.class);
  }

  public List<Pedido> listarTodos() throws Exception {
    List<Pedido> pedidos = new DAO<Pedido>().listarTodos(Pedido.class);

    return pedidos;
  }

  public Pedido consultarPorId(Integer id) throws Exception {
    Pedido pedido = new DAO<Pedido>().consultarPorId(id, Pedido.class);

    return pedido;
  }
}
