package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredienteBuilder;
import br.unigran.restaurante.app.models.Ingrediente;
import br.unigran.restaurante.app.persistence.IngredienteDAO;

public class IngredienteUC {
    public Ingrediente salvar(IngredienteBuilder ingredienteBuilder) throws Exception {
        Ingrediente ingrediente = new IngredienteDAO().salvar(ingredienteBuilder.build());

        System.out.println(ingrediente.toString());

        return ingrediente;
    }

    public Ingrediente atualizar(IngredienteBuilder ingredienteBuilder, Ingrediente ingrediente) throws Exception {
        Ingrediente ingredienteAtualizado = new IngredienteDAO().salvar(ingredienteBuilder.build(ingrediente));

        System.out.println(ingredienteAtualizado.toString());

        return ingredienteAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new IngredienteDAO().remover(id);
    }

    public List<Ingrediente> listarTodos() throws Exception {
        List<Ingrediente> ingredientes = new IngredienteDAO().listarTodos();

        for (int i = 0; i < ingredientes.size(); i++) {
            System.out.println(ingredientes.get(i).toString());
        }

        return ingredientes;
    }

    public Ingrediente consultarPorId(Integer id) throws Exception {
        Ingrediente ingrediente = new IngredienteDAO().consultarPorId(id);

        System.out.println(ingrediente.toString());

        return ingrediente;
    }
}
