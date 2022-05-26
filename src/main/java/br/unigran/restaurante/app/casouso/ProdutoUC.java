package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ProdutoBuilder;
import br.unigran.restaurante.app.models.Produto;
import br.unigran.restaurante.app.persistence.DAO;

public class ProdutoUC {
    public Produto salvar(ProdutoBuilder produtoBuilder) throws Exception {
        Produto produto = produtoBuilder.build();
        produto = new DAO<Produto>().salvar(produto, Produto.class, produto.getId().intValue());

        System.out.println(produto.toString());

        return produto;
    }

    public Produto atualizar(ProdutoBuilder produtoBuilder, Produto produto) throws Exception {
        Produto produtoAnterior = produtoBuilder.build(produto);
        Produto produtoAtualizado = new DAO<Produto>().salvar(produtoAnterior, Produto.class,
                produtoAnterior.getId().intValue());

        System.out.println(produtoAtualizado.toString());

        return produtoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new DAO<Produto>().remover(id, Produto.class);
    }

    public List<Produto> listarTodos() throws Exception {
        List<Produto> produtos = new DAO<Produto>().listarTodos(Produto.class);

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i).toString());
        }

        return produtos;
    }

    public Produto consultarPorId(Integer id) throws Exception {
        Produto produto = new DAO<Produto>().consultarPorId(id, Produto.class);

        System.out.println(produto.toString());

        return produto;
    }
}
