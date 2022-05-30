package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredienteBuilder;
import br.unigran.restaurante.app.models.Ingrediente;
import br.unigran.restaurante.app.persistence.DAO;

public class IngredienteUC {
    public Ingrediente salvar(IngredienteBuilder ingredienteBuilder) throws Exception {
        Ingrediente ingrediente = ingredienteBuilder.build();
        ingrediente = new DAO<Ingrediente>().salvar(ingrediente, Ingrediente.class, ingrediente.getId());

        return ingrediente;
    }

    public Ingrediente atualizar(IngredienteBuilder ingredienteBuilder, Ingrediente ingrediente) throws Exception {
        Ingrediente ingredienteAnterior = ingredienteBuilder.build(ingrediente);
        Ingrediente ingredienteAtualizado = new DAO<Ingrediente>().salvar(ingredienteAnterior, Ingrediente.class,
                ingredienteAnterior.getId());

        return ingredienteAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new DAO<Ingrediente>().remover(id, Ingrediente.class);
    }

    public List<Ingrediente> listarTodos() throws Exception {
        List<Ingrediente> ingredientes = new DAO<Ingrediente>().listarTodos(Ingrediente.class);

        return ingredientes;
    }

    public Ingrediente consultarPorId(Integer id) throws Exception {
        Ingrediente ingrediente = new DAO<Ingrediente>().consultarPorId(id, Ingrediente.class);

        return ingrediente;
    }
}
