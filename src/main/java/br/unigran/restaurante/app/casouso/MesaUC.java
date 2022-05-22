package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.MesaBuilder;
import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.persistence.MesaDAO;

public class MesaUC {
    public Mesa salvar(MesaBuilder mesaBuilder) throws Exception {
        Mesa mesa = new MesaDAO().salvar(mesaBuilder.build());

        System.out.println(mesa.toString());

        return mesa;
    }

    public Mesa atualizar(MesaBuilder mesaBuilder, Mesa mesa) throws Exception {
        Mesa mesaAtualizado = new MesaDAO().salvar(mesaBuilder.build(mesa));

        System.out.println(mesaAtualizado.toString());

        return mesaAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new MesaDAO().remover(id);
    }

    public List<Mesa> listarTodos() throws Exception {
        List<Mesa> mesas = new MesaDAO().listarTodos();

        for (int i = 0; i < mesas.size(); i++) {
            System.out.println(mesas.get(i).toString());
        }

        return mesas;
    }

    public Mesa consultarPorId(Integer id) throws Exception {
        Mesa mesa = new MesaDAO().consultarPorId(id);

        System.out.println(mesa.toString());

        return mesa;
    }
}
