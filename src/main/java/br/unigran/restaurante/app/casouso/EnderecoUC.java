package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.EnderecoBuilder;
import br.unigran.restaurante.app.models.Endereco;
import br.unigran.restaurante.app.persistence.EnderecoDAO;

public class EnderecoUC {
    public Endereco salvar(EnderecoBuilder enderecoBuilder) throws Exception {
        Endereco endereco = new EnderecoDAO().salvar(enderecoBuilder.build());

        System.out.println(endereco.toString());

        return endereco;
    }

    public Endereco atualizar(EnderecoBuilder enderecoBuilder, Endereco endereco) throws Exception {
        Endereco enderecoAtualizado = new EnderecoDAO().salvar(enderecoBuilder.build(endereco));

        System.out.println(enderecoAtualizado.toString());

        return enderecoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new EnderecoDAO().remover(id);
    }

    public List<Endereco> listarTodos() throws Exception {
        List<Endereco> enderecos = new EnderecoDAO().listarTodos();

        for (int i = 0; i < enderecos.size(); i++) {
            System.out.println(enderecos.get(i).toString());
        }

        return enderecos;
    }

    public Endereco consultarPorId(Integer id) throws Exception {
        Endereco endereco = new EnderecoDAO().consultarPorId(id);

        System.out.println(endereco.toString());

        return endereco;
    }
}
