package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.CargoPapelBuilder;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.CargoPapel;
import br.unigran.restaurante.app.persistence.DAO;
import br.unigran.restaurante.app.persistence.CargoPapelDAO;

public final class CargoPapelUC {
    private static CargoPapelDAO DAO = new CargoPapelDAO();
    
    public static CargoPapel salvar(CargoPapelBuilder cargoPapelBuilder) throws Exception {
        CargoPapel cargoPapel = cargoPapelBuilder.build();
        cargoPapel = DAO.salvar(cargoPapel, CargoPapel.class, cargoPapel.getId());
        return cargoPapel;
    }

    public static CargoPapel atualizar(CargoPapelBuilder cargoPapelBuilder, CargoPapel cargoPapel) throws Exception {
        CargoPapel cargoPapelAnterior = cargoPapelBuilder.build(cargoPapel);
        CargoPapel cargoPapelAtualizado = DAO.salvar(cargoPapelAnterior, CargoPapel.class, cargoPapelAnterior.getId());
        return cargoPapelAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, CargoPapel.class);
    }

    public static List<CargoPapel> listarTodos() throws Exception {
        List<CargoPapel> cargoPapeis = DAO.listarTodos(CargoPapel.class);
        return cargoPapeis;
    }
    
    public static List<CargoPapel> buscarPapeis(Cargo cargo) throws Exception {
        List<CargoPapel> cargoPapeis = DAO.buscarPapeis(cargo);
        return cargoPapeis;
    }

    public static CargoPapel consultarPorId(Integer id) throws Exception {
        CargoPapel cargoPapel = DAO.consultarPorId(id, CargoPapel.class);
        return cargoPapel;
    }
}
