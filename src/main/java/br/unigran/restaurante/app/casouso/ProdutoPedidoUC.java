package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ProdutoPedidoBuilder;
import br.unigran.restaurante.app.models.ProdutoPedido;
import br.unigran.restaurante.app.persistence.DAO;

public final class ProdutoPedidoUC {
    private static DAO<ProdutoPedido> DAO = new DAO<ProdutoPedido>();
    
    public static ProdutoPedido salvar(ProdutoPedidoBuilder produtoPedidoBuilder) throws Exception {
        ProdutoPedido produtoPedido = produtoPedidoBuilder.build();
        produtoPedido = DAO.salvar(produtoPedido, ProdutoPedido.class, produtoPedido.getId());
        return produtoPedido;
    }

    public static ProdutoPedido atualizar(ProdutoPedidoBuilder produtoPedidoBuilder, ProdutoPedido produtoPedido) throws Exception {
        ProdutoPedido produtoPedidoAnterior = produtoPedidoBuilder.build(produtoPedido);
        ProdutoPedido produtoPedidoAtualizado = DAO.salvar(produtoPedidoAnterior, ProdutoPedido.class, produtoPedidoAnterior.getId());
        return produtoPedidoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, ProdutoPedido.class);
    }

    public static List<ProdutoPedido> listarTodos() throws Exception {
        List<ProdutoPedido> produtoPedidos = DAO.listarTodos(ProdutoPedido.class);
        return produtoPedidos;
    }

    public static ProdutoPedido consultarPorId(Long id) throws Exception {
        ProdutoPedido produtoPedido = DAO.consultarPorId(id.intValue(), ProdutoPedido.class);
        return produtoPedido;
    }
}
