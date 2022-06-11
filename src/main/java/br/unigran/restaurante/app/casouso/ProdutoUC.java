package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ProdutoBuilder;
import br.unigran.restaurante.app.models.Produto;
import br.unigran.restaurante.app.persistence.DAO;

public final class ProdutoUC {
    private static DAO<Produto> DAO = new DAO<Produto>();
    
    public static Produto salvar(ProdutoBuilder produtoBuilder) throws Exception {
        Produto produto = produtoBuilder.build();
        produto = DAO.salvar(produto, Produto.class, produto.getId());
        return produto;
    }

    public static Produto atualizar(ProdutoBuilder produtoBuilder, Produto produto) throws Exception {
        Produto produtoAnterior = produtoBuilder.build(produto);
        Produto produtoAtualizado = DAO.salvar(produtoAnterior, Produto.class, produtoAnterior.getId());
        return produtoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Produto.class);
    }

    public static List<Produto> listarTodos() throws Exception {
        List<Produto> produtos = DAO.listarTodos(Produto.class);
        return produtos;
    }

    public static Produto consultarPorId(Integer id) throws Exception {
        Produto produto = DAO.consultarPorId(id, Produto.class);
        return produto;
    }
}
