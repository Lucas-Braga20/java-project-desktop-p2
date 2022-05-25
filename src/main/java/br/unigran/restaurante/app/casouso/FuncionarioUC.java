package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.FuncionarioBuilder;
import br.unigran.restaurante.app.models.Funcionario;
import br.unigran.restaurante.app.persistence.FuncionarioDAO;

public class FuncionarioUC {
    public Funcionario salvar(FuncionarioBuilder funcionarioBuilder) throws Exception {
        Funcionario funcionario = new FuncionarioDAO().salvar(funcionarioBuilder.build());

        System.out.println(funcionario.toString());

        return funcionario;
    }

    public Funcionario atualizar(FuncionarioBuilder funcionarioBuilder, Funcionario funcionario) throws Exception {
        Funcionario funcionarioAtualizado = new FuncionarioDAO().salvar(funcionarioBuilder.build(funcionario));

        System.out.println(funcionarioAtualizado.toString());

        return funcionarioAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new FuncionarioDAO().remover(id);
    }

    public List<Funcionario> listarTodos() throws Exception {
        List<Funcionario> funcionarios = new FuncionarioDAO().listarTodos();

        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println(funcionarios.get(i).toString());
        }

        return funcionarios;
    }

    public Funcionario consultarPorId(Integer id) throws Exception {
        Funcionario funcionario = new FuncionarioDAO().consultarPorId(id);

        System.out.println(funcionario.toString());

        return funcionario;
    }
}
