package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.ProdutoBuilder;
import br.unigran.restaurante.app.models.Produto;
import br.unigran.restaurante.app.persistence.ProdutoDAO;

public class ProdutoUC {
    public Produto salvar(ProdutoBuilder produtoBuilder) throws Exception {
        Produto produto = new ProdutoDAO().salvar(produtoBuilder.build());

        System.out.println(produto.toString());

        return produto;
    }

    public Produto atualizar(ProdutoBuilder produtoBuilder, Produto produto) throws Exception {
        Produto produtoAtualizado = new ProdutoDAO().salvar(produtoBuilder.build(produto));

        System.out.println(produtoAtualizado.toString());

        return produtoAtualizado;
    }

    public void remover(Long id) throws Exception {
        new ProdutoDAO().remover(id);
    }

    public List<Produto> listarTodos() throws Exception {
        List<Produto> produtos = new ProdutoDAO().listarTodos();

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i).toString());
        }

        return produtos;
    }

    public Produto consultarPorId(Long id) throws Exception {
        Produto produto = new ProdutoDAO().consultarPorId(id);

        System.out.println(produto.toString());

        return produto;
    }
}
