package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PedidoBuilder;
import br.unigran.restaurante.app.models.Cliente;
import br.unigran.restaurante.app.models.Funcionario;
import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.models.Pedido;
import br.unigran.restaurante.app.persistence.DAO;
import java.util.Date;

public final class PedidoUC {
    private static DAO<Pedido> DAO = new DAO<Pedido>();
    
    public static Pedido salvar(PedidoBuilder pedidoBuilder) throws Exception {
        Pedido pedido = pedidoBuilder.build();
        pedido = DAO.salvar(pedido, Pedido.class, pedido.getId());
        MesaUC.OcuparMesa(pedido.getMesa().getId());
        return pedido;
    }

    public static Pedido atualizar(PedidoBuilder pedidoBuilder, Pedido pedido) throws Exception {
        Pedido pedidoAnterior = pedidoBuilder.build(pedido);
        Pedido pedidoAtualizado = DAO.salvar(pedidoAnterior, Pedido.class, pedidoAnterior.getId());
        if (!pedido.getMesa().getOcupada()) {
            MesaUC.OcuparMesa(pedido.getMesa().getId());
        }
        return pedidoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Pedido.class);
    }

    public static List<Pedido> listarTodos() throws Exception {
        List<Pedido> pedidos = DAO.listarTodos(Pedido.class);
        return pedidos;
    }

    public static Pedido consultarPorId(Integer id) throws Exception {
        Pedido pedido = DAO.consultarPorId(id, Pedido.class);
        return pedido;
    }
}
