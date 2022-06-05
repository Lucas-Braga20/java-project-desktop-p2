package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Pedido;
import br.unigran.restaurante.app.models.ProdutoPedido;
import java.util.List;
import javax.persistence.EntityManager;

public class ProdutoPedidoDAO {
    @SuppressWarnings("uncheked")
    public List<ProdutoPedido> listarTodos(Pedido pedido) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<ProdutoPedido> produtoPedidos = null;

        try {
            produtoPedidos = em.createQuery(
                "FROM ProdutoPedido o WHERE o.pedido.id = :pedidoId"
            ).setParameter("pedidoId", pedido.getId()).getResultList();
        } catch (Exception e) {
            throw e;
        }
        
        return produtoPedidos;
    }
}
