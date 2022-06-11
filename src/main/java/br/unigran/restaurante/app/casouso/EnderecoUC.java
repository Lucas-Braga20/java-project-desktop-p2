package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.EnderecoBuilder;
import br.unigran.restaurante.app.enums.Cidade;
import br.unigran.restaurante.app.models.Endereco;
import br.unigran.restaurante.app.persistence.DAO;

public final class EnderecoUC {
    private static DAO<Endereco> DAO = new DAO<Endereco>();
    
    public static Endereco salvar(EnderecoBuilder enderecoBuilder) throws Exception {
        Endereco endereco = enderecoBuilder.build();
        endereco = DAO.salvar(endereco, Endereco.class, endereco.getId());
        return endereco;
    }

    public static Endereco atualizar(EnderecoBuilder enderecoBuilder, Endereco endereco) throws Exception {
        Endereco enderecoAnterior = enderecoBuilder.build(endereco);
        Endereco enderecoAtualizado = DAO.salvar(enderecoAnterior, Endereco.class, enderecoAnterior.getId());
        return enderecoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Endereco.class);
    }

    public static List<Endereco> listarTodos() throws Exception {
        List<Endereco> enderecos = DAO.listarTodos(Endereco.class);
        return enderecos;
    }

    public static Endereco consultarPorId(Integer id) throws Exception {
        Endereco endereco = DAO.consultarPorId(id, Endereco.class);
        return endereco;
    }
}
