package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ClienteBuilder;
import br.unigran.restaurante.app.models.Cliente;
import br.unigran.restaurante.app.models.Endereco;
import br.unigran.restaurante.app.persistence.DAO;
import java.util.Date;

public final class ClienteUC {
    private static DAO<Cliente> DAO = new DAO<Cliente>();
    
    public static Cliente salvar(ClienteBuilder clienteBuilder) throws Exception {
        Cliente cliente = clienteBuilder.build();
        cliente = DAO.salvar(cliente, Cliente.class, cliente.getId());
        return cliente;
    }

    public static Cliente atualizar(ClienteBuilder clienteBuilder, Cliente cliente) throws Exception {
        Cliente clienteAnterior = clienteBuilder.build(cliente);
        Cliente clienteAtualizado = DAO.salvar(clienteAnterior, Cliente.class, clienteAnterior.getId());
        return clienteAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Cliente.class);
    }

    public static List<Cliente> listarTodos() throws Exception {
        List<Cliente> clientes = DAO.listarTodos(Cliente.class);
        return clientes;
    }

    public static Cliente consultarPorId(Integer id) throws Exception {
        Cliente cliente = DAO.consultarPorId(id, Cliente.class);
        return cliente;
    }
}
