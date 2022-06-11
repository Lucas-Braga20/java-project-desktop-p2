package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.FuncionarioBuilder;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.Endereco;
import br.unigran.restaurante.app.models.Funcionario;
import br.unigran.restaurante.app.persistence.DAO;
import java.util.Date;

public final class FuncionarioUC {
    private static DAO<Funcionario> DAO = new DAO<Funcionario>();
    
    public static Funcionario salvar(FuncionarioBuilder funcionarioBuilder) throws Exception {
        Funcionario funcionario = funcionarioBuilder.build();
        funcionario = DAO.salvar(funcionario, Funcionario.class, funcionario.getId());
        return funcionario;
    }

    public static Funcionario atualizar(FuncionarioBuilder funcionarioBuilder, Funcionario funcionario) throws Exception {
        Funcionario funcionarioAnterior = funcionarioBuilder.build(funcionario);
        Funcionario funcionarioAtualizado = DAO.salvar(funcionarioAnterior, Funcionario.class, funcionarioAnterior.getId());
        return funcionarioAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Funcionario.class);
    }

    public static List<Funcionario> listarTodos() throws Exception {
        List<Funcionario> funcionarios = DAO.listarTodos(Funcionario.class);
        return funcionarios;
    }

    public static Funcionario consultarPorId(Integer id) throws Exception {
        Funcionario funcionario = DAO.consultarPorId(id, Funcionario.class);
        return funcionario;
    }
}
