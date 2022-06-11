package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PratoBuilder;
import br.unigran.restaurante.app.models.Prato;
import br.unigran.restaurante.app.persistence.DAO;

public final class PratoUC {
    private static DAO<Prato> DAO = new DAO<Prato>();
    
    public static Prato salvar(PratoBuilder pratoBuilder) throws Exception {
        Prato prato = pratoBuilder.build();
        prato = DAO.salvar(prato, Prato.class, prato.getId());
        return prato;
    }

    public static Prato atualizar(PratoBuilder pratoBuilder, Prato prato) throws Exception {
        Prato pratoAnterior = pratoBuilder.build(prato);
        Prato pratoAtualizado = DAO.salvar(pratoAnterior, Prato.class, pratoAnterior.getId());
        return pratoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Prato.class);
    }

    public static List<Prato> listarTodos() throws Exception {
        List<Prato> pratos = DAO.listarTodos(Prato.class);
        return pratos;
    }

    public static Prato consultarPorId(Integer id) throws Exception {
        Prato prato = DAO.consultarPorId(id, Prato.class);
        return prato;
    }
}
