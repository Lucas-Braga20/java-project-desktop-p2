package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredienteBuilder;
import br.unigran.restaurante.app.models.Ingrediente;
import br.unigran.restaurante.app.persistence.DAO;

public class IngredienteUC {
    public Ingrediente salvar(IngredienteBuilder ingredienteBuilder) throws Exception {
        Ingrediente ingrediente = ingredienteBuilder.build();
        ingrediente = new DAO<Ingrediente>().salvar(ingrediente, Ingrediente.class, ingrediente.getId().intValue());

        System.out.println(ingrediente.toString());

        return ingrediente;
    }

    public Ingrediente atualizar(IngredienteBuilder ingredienteBuilder, Ingrediente ingrediente) throws Exception {
        Ingrediente ingredienteAnterior = ingredienteBuilder.build(ingrediente);
        Ingrediente ingredienteAtualizado = new DAO<Ingrediente>().salvar(ingredienteAnterior, Ingrediente.class,
                ingredienteAnterior.getId().intValue());

        System.out.println(ingredienteAtualizado.toString());

        return ingredienteAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new DAO<Ingrediente>().remover(id, Ingrediente.class);
    }

    public List<Ingrediente> listarTodos() throws Exception {
        List<Ingrediente> ingredientes = new DAO<Ingrediente>().listarTodos(Ingrediente.class);

        for (int i = 0; i < ingredientes.size(); i++) {
            System.out.println(ingredientes.get(i).toString());
        }

        return ingredientes;
    }

    public Ingrediente consultarPorId(Integer id) throws Exception {
        Ingrediente ingrediente = new DAO<Ingrediente>().consultarPorId(id, Ingrediente.class);

        System.out.println(ingrediente.toString());

        return ingrediente;
    }
}
