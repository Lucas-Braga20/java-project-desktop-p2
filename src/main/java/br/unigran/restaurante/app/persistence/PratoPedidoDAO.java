/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Pedido;
import br.unigran.restaurante.app.models.PratoPedido;
import br.unigran.restaurante.app.models.ProdutoPedido;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Lucas
 */
public class PratoPedidoDAO {
    @SuppressWarnings("uncheked")
    public List<PratoPedido> listarTodos(Pedido pedido) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<PratoPedido> pratoPedidos = null;

        try {
            pratoPedidos = em.createQuery(
                "FROM PratoPedido o WHERE o.pedido.id = :pedidoId"
            ).setParameter("pedidoId", pedido.getId()).getResultList();
        } catch (Exception e) {
            throw e;
        }
        
        return pratoPedidos;
    }
}
