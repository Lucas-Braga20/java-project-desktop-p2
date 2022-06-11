package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.MesaBuilder;
import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.persistence.DAO;
import br.unigran.restaurante.app.persistence.MesaDAO;

public final class MesaUC {
    private static MesaDAO DAO = new MesaDAO();
    
    public static Mesa salvar(MesaBuilder mesaBuilder) throws Exception {
        Mesa mesa = mesaBuilder.build();
        mesa = DAO.salvar(mesa, Mesa.class, mesa.getId());
        return mesa;
    }

    public static Mesa atualizar(MesaBuilder mesaBuilder, Mesa mesa) throws Exception {
        Mesa mesaAnterior = mesaBuilder.build(mesa);
        Mesa mesaAtualizado = DAO.salvar(mesaAnterior, Mesa.class, mesaAnterior.getId());
        return mesaAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Mesa.class);
    }

    public static void OcuparMesa(Integer id) throws Exception {
        DAO.ocuparMesa(id);
    }

    public static void DesocuparMesa(Integer id) throws Exception {
        DAO.desocuparMesa(id);
    }

    public static List<Mesa> listarTodos() throws Exception {
        List<Mesa> mesas = DAO.listarTodos(Mesa.class);
        return mesas;
    }
    
    public static List<Mesa> listarNaoOcupada() throws Exception {
        List<Mesa> mesas = DAO.listarNaoOcupada();
        return mesas;
    }

    public static Mesa consultarPorId(Integer id) throws Exception {
        Mesa mesa = DAO.consultarPorId(id, Mesa.class);
        return mesa;
    }
}
