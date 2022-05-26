package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.EnderecoBuilder;
import br.unigran.restaurante.app.models.Endereco;
import br.unigran.restaurante.app.persistence.DAO;

public class EnderecoUC {
    public Endereco salvar(EnderecoBuilder enderecoBuilder) throws Exception {
        Endereco endereco = enderecoBuilder.build();
        endereco = new DAO<Endereco>().salvar(endereco, Endereco.class, endereco.getId().intValue());

        System.out.println(endereco.toString());

        return endereco;
    }

    public Endereco atualizar(EnderecoBuilder enderecoBuilder, Endereco endereco) throws Exception {
        Endereco enderecoAnterior = enderecoBuilder.build(endereco);
        Endereco enderecoAtualizado = new DAO<Endereco>().salvar(enderecoAnterior, Endereco.class,
                enderecoAnterior.getId().intValue());

        System.out.println(enderecoAtualizado.toString());

        return enderecoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new DAO<Endereco>().remover(id, Endereco.class);
    }

    public List<Endereco> listarTodos() throws Exception {
        List<Endereco> enderecos = new DAO<Endereco>().listarTodos(Endereco.class);

        for (int i = 0; i < enderecos.size(); i++) {
            System.out.println(enderecos.get(i).toString());
        }

        return enderecos;
    }

    public Endereco consultarPorId(Integer id) throws Exception {
        Endereco endereco = new DAO<Endereco>().consultarPorId(id, Endereco.class);

        System.out.println(endereco.toString());

        return endereco;
    }
}
