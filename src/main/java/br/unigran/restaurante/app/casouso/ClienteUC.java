package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ClienteBuilder;
import br.unigran.restaurante.app.models.Cliente;
import br.unigran.restaurante.app.persistence.ClienteDAO;

public class ClienteUC {
    public Cliente salvar(ClienteBuilder clienteBuilder) throws Exception {
        Cliente cliente = new ClienteDAO().salvar(clienteBuilder.build());

        System.out.println(cliente.toString());

        return cliente;
    }

    public Cliente atualizar(ClienteBuilder clienteBuilder, Cliente cliente) throws Exception {
        Cliente clienteAtualizado = new ClienteDAO().salvar(clienteBuilder.build(cliente));

        System.out.println(clienteAtualizado.toString());

        return clienteAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new ClienteDAO().remover(id);
    }

    public List<Cliente> listarTodos() throws Exception {
        List<Cliente> clientes = new ClienteDAO().listarTodos();

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).toString());
        }

        return clientes;
    }

    public Cliente consultarPorId(Integer id) throws Exception {
        Cliente cliente = new ClienteDAO().consultarPorId(id);

        System.out.println(cliente.toString());

        return cliente;
    }
}
