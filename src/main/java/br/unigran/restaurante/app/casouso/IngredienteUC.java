package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.IngredienteBuilder;
import br.unigran.restaurante.app.enums.UnidadeMedida;
import br.unigran.restaurante.app.models.Ingrediente;
import br.unigran.restaurante.app.persistence.DAO;

public final class IngredienteUC {
    private static DAO<Ingrediente> DAO = new DAO<Ingrediente>();
    
    public static Ingrediente salvar(IngredienteBuilder ingredienteBuilder) throws Exception {
        Ingrediente ingrediente = ingredienteBuilder.build();
        ingrediente = DAO.salvar(
            ingrediente, Ingrediente.class, ingrediente.getId()
        );
        return ingrediente;
    }

    public static Ingrediente atualizar(IngredienteBuilder ingredienteBuilder, Ingrediente ingrediente) throws Exception {
        Ingrediente ingredienteAnterior = ingredienteBuilder.build(ingrediente);
        Ingrediente ingredienteAtualizado = DAO.salvar(
            ingredienteAnterior, Ingrediente.class, ingredienteAnterior.getId()
        );
        return ingredienteAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Ingrediente.class);
    }

    public static List<Ingrediente> listarTodos() throws Exception {
        List<Ingrediente> ingredientes = DAO.listarTodos(Ingrediente.class);
        return ingredientes;
    }

    public static Ingrediente consultarPorId(Integer id) throws Exception {
        Ingrediente ingrediente = DAO.consultarPorId(id, Ingrediente.class);
        return ingrediente;
    }
}
