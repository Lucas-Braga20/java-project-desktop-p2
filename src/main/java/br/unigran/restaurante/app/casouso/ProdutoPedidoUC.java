package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ProdutoPedidoBuilder;
import br.unigran.restaurante.app.models.ProdutoPedido;
import br.unigran.restaurante.app.persistence.DAO;

public class ProdutoPedidoUC {
  public ProdutoPedido salvar(ProdutoPedidoBuilder produtoPedidoBuilder) throws Exception {
    ProdutoPedido produtoPedido = produtoPedidoBuilder.build();
    produtoPedido = new DAO<ProdutoPedido>().salvar(produtoPedido, ProdutoPedido.class, produtoPedido.getId());

    return produtoPedido;
  }

  public ProdutoPedido atualizar(ProdutoPedidoBuilder produtoPedidoBuilder, ProdutoPedido produtoPedido) throws Exception {
    ProdutoPedido produtoPedidoAnterior = produtoPedidoBuilder.build(produtoPedido);
    ProdutoPedido produtoPedidoAtualizado = new DAO<ProdutoPedido>().salvar(produtoPedidoAnterior, ProdutoPedido.class, produtoPedidoAnterior.getId());

    return produtoPedidoAtualizado;
  }

  public void remover(Long id) throws Exception {
    new DAO<ProdutoPedido>().remover(id.intValue(), ProdutoPedido.class);
  }

  public List<ProdutoPedido> listarTodos() throws Exception {
    List<ProdutoPedido> produtoPedidos = new DAO<ProdutoPedido>().listarTodos(ProdutoPedido.class);

    return produtoPedidos;
  }

  public ProdutoPedido consultarPorId(Long id) throws Exception {
    ProdutoPedido produtoPedido = new DAO<ProdutoPedido>().consultarPorId(id.intValue(), ProdutoPedido.class);

    return produtoPedido;
  }
}
