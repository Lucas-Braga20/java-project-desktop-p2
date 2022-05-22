package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.PratoBuilder;
import br.unigran.restaurante.app.models.Prato;
import br.unigran.restaurante.app.persistence.PratoDAO;

public class PratoUC {
    public Prato salvar(PratoBuilder pratoBuilder) throws Exception {
        Prato prato = new PratoDAO().salvar(pratoBuilder.build());

        System.out.println(prato.toString());

        return prato;
    }

    public Prato atualizar(PratoBuilder pratoBuilder, Prato prato) throws Exception {
        Prato pratoAtualizado = new PratoDAO().salvar(pratoBuilder.build(prato));

        System.out.println(pratoAtualizado.toString());

        return pratoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new PratoDAO().remover(id);
    }

    public List<Prato> listarTodos() throws Exception {
        List<Prato> pratos = new PratoDAO().listarTodos();

        for (int i = 0; i < pratos.size(); i++) {
            System.out.println(pratos.get(i).toString());
        }

        return pratos;
    }

    public Prato consultarPorId(Integer id) throws Exception {
        Prato prato = new PratoDAO().consultarPorId(id);

        System.out.println(prato.toString());

        return prato;
    }
}
