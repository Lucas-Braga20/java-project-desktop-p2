package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ClienteBuilder;
import br.unigran.restaurante.app.models.Cliente;
import br.unigran.restaurante.app.persistence.DAO;

public class ClienteUC {
  public Cliente salvar(ClienteBuilder clienteBuilder) throws Exception {
    Cliente cliente = clienteBuilder.build();
    cliente = new DAO<Cliente>().salvar(cliente, Cliente.class, cliente.getId());

    return cliente;
  }

  public Cliente atualizar(ClienteBuilder clienteBuilder, Cliente cliente) throws Exception {
    Cliente clienteAnterior = clienteBuilder.build(cliente);
    Cliente clienteAtualizado = new DAO<Cliente>().salvar(clienteAnterior, Cliente.class, clienteAnterior.getId());

    return clienteAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<Cliente>().remover(id, Cliente.class);
  }

  public List<Cliente> listarTodos() throws Exception {
    List<Cliente> clientes = new DAO<Cliente>().listarTodos(Cliente.class);

    return clientes;
  }

  public Cliente consultarPorId(Integer id) throws Exception {
    Cliente cliente = new DAO<Cliente>().consultarPorId(id, Cliente.class);

    return cliente;
  }
}
