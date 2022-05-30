package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PratoBuilder;
import br.unigran.restaurante.app.models.Prato;
import br.unigran.restaurante.app.persistence.DAO;

public class PratoUC {
    public Prato salvar(PratoBuilder pratoBuilder) throws Exception {
        Prato prato = pratoBuilder.build();
        prato = new DAO<Prato>().salvar(prato, Prato.class, prato.getId());

        return prato;
    }

    public Prato atualizar(PratoBuilder pratoBuilder, Prato prato) throws Exception {
        Prato pratoAnterior = pratoBuilder.build(prato);
        Prato pratoAtualizado = new DAO<Prato>().salvar(pratoAnterior, Prato.class,
                pratoAnterior.getId());

        return pratoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new DAO<Prato>().remover(id, Prato.class);
    }

    public List<Prato> listarTodos() throws Exception {
        List<Prato> pratos = new DAO<Prato>().listarTodos(Prato.class);

        return pratos;
    }

    public Prato consultarPorId(Integer id) throws Exception {
        Prato prato = new DAO<Prato>().consultarPorId(id, Prato.class);

        return prato;
    }
}
