package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ProdutoBuilder;
import br.unigran.restaurante.app.models.Produto;
import br.unigran.restaurante.app.persistence.DAO;

public class ProdutoUC {
    public Produto salvar(ProdutoBuilder produtoBuilder) throws Exception {
        Produto produto = produtoBuilder.build();
        produto = new DAO<Produto>().salvar(produto, Produto.class, produto.getId());

        return produto;
    }

    public Produto atualizar(ProdutoBuilder produtoBuilder, Produto produto) throws Exception {
        Produto produtoAnterior = produtoBuilder.build(produto);
        Produto produtoAtualizado = new DAO<Produto>().salvar(produtoAnterior, Produto.class,
                produtoAnterior.getId().intValue());

        return produtoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new DAO<Produto>().remover(id, Produto.class);
    }

    public List<Produto> listarTodos() throws Exception {
        List<Produto> produtos = new DAO<Produto>().listarTodos(Produto.class);

        return produtos;
    }

    public Produto consultarPorId(Integer id) throws Exception {
        Produto produto = new DAO<Produto>().consultarPorId(id, Produto.class);

        return produto;
    }
}
