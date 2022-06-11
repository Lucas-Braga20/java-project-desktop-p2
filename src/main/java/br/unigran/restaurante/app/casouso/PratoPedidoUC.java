package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PratoPedidoBuilder;
import br.unigran.restaurante.app.models.PratoPedido;
import br.unigran.restaurante.app.persistence.DAO;

public final class PratoPedidoUC {
    private static DAO<PratoPedido> DAO = new DAO<PratoPedido>();
    
    public static PratoPedido salvar(PratoPedidoBuilder pratoPedidoBuilder) throws Exception {
        PratoPedido pratoPedido = pratoPedidoBuilder.build();
        pratoPedido = DAO.salvar(pratoPedido, PratoPedido.class, pratoPedido.getId());
        return pratoPedido;
    }

    public static PratoPedido atualizar(PratoPedidoBuilder pratoPedidoBuilder, PratoPedido pratoPedido) throws Exception {
        PratoPedido pratoPedidoAnterior = pratoPedidoBuilder.build(pratoPedido);
        PratoPedido pratoPedidoAtualizado = DAO.salvar(pratoPedidoAnterior, PratoPedido.class, pratoPedidoAnterior.getId());
        return pratoPedidoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, PratoPedido.class);
    }

    public static List<PratoPedido> listarTodos() throws Exception {
        List<PratoPedido> pratoPedidos = DAO.listarTodos(PratoPedido.class);
        return pratoPedidos;
    }

    public static PratoPedido consultarPorId(Integer id) throws Exception {
        PratoPedido pratoPedido = DAO.consultarPorId(id, PratoPedido.class);
        return pratoPedido;
    }
}
