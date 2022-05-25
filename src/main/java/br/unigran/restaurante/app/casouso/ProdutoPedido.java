package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ProdutoPedidoBuilder;
import br.unigran.restaurante.app.models.ProdutoPedido;
import br.unigran.restaurante.app.persistence.ProdutoPedidoDAO;

public class ProdutoPedidoUC {
  public ProdutoPedido salvar(ProdutoPedidoBuilder produtoPedidoBuilder) throws Exception {
    ProdutoPedido produtoPedido = new ProdutoPedidoDAO().salvar(produtoPedidoBuilder.build());

    System.out.println(produtoPedido.toString());

    return produtoPedido;
  }

  public ProdutoPedido atualizar(ProdutoPedidoBuilder produtoPedidoBuilder, ProdutoPedido produtoPedido)
      throws Exception {
    ProdutoPedido produtoPedidoAtualizado = new ProdutoPedidoDAO().salvar(produtoPedidoBuilder.build(produtoPedido));

    System.out.println(produtoPedidoAtualizado.toString());

    return produtoPedidoAtualizado;
  }

  public void remover(Long id) throws Exception {
    new ProdutoPedidoDAO().remover(id);
  }

  public List<ProdutoPedido> listarTodos() throws Exception {
    List<ProdutoPedido> produtoPedidos = new ProdutoPedidoDAO().listarTodos();

    for (int i = 0; i < produtoPedidos.size(); i++) {
      System.out.println(produtoPedidos.get(i).toString());
    }

    return produtoPedidos;
  }

  public ProdutoPedido consultarPorId(Long id) throws Exception {
    ProdutoPedido produtoPedido = new ProdutoPedidoDAO().consultarPorId(id);

    System.out.println(produtoPedido.toString());

    return produtoPedido;
  }
}
