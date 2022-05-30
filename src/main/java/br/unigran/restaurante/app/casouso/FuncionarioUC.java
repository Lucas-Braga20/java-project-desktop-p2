package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.FuncionarioBuilder;
import br.unigran.restaurante.app.models.Funcionario;
import br.unigran.restaurante.app.persistence.DAO;

public class FuncionarioUC {
  public Funcionario salvar(FuncionarioBuilder funcionarioBuilder) throws Exception {
    Funcionario funcionario = funcionarioBuilder.build();
    funcionario = new DAO<Funcionario>().salvar(funcionario, Funcionario.class, funcionario.getId());

    return funcionario;
  }

  public Funcionario atualizar(FuncionarioBuilder funcionarioBuilder, Funcionario funcionario) throws Exception {
    Funcionario funcionarioAnterior = funcionarioBuilder.build(funcionario);
    Funcionario funcionarioAtualizado = new DAO<Funcionario>().salvar(funcionarioAnterior, Funcionario.class, funcionarioAnterior.getId());

    return funcionarioAtualizado;
  }

  public void remover(Integer id) throws Exception {
    new DAO<Funcionario>().remover(id, Funcionario.class);
  }

  public List<Funcionario> listarTodos() throws Exception {
    List<Funcionario> funcionarios = new DAO<Funcionario>().listarTodos(Funcionario.class);

    return funcionarios;
  }

  public Funcionario consultarPorId(Integer id) throws Exception {
    Funcionario funcionario = new DAO<Funcionario>().consultarPorId(id, Funcionario.class);

    return funcionario;
  }
}
