package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Pedido;
import br.unigran.restaurante.app.models.Produto;
import br.unigran.restaurante.app.models.ProdutoPedido;

public class ProdutoPedidoBuilder {
    private Float valorUnitario;
    private Integer quantidade;
    private Produto produto;
    private Pedido pedido;

    public ProdutoPedidoBuilder(Float valorUnitario, Integer quantidade, Produto produto, Pedido pedido) {
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
    }
    public ProdutoPedidoBuilder(ProdutoPedido produtoPedido) {
        this.valorUnitario = produtoPedido.getValorUnitario();
        this.quantidade = produtoPedido.getQuantidade();
        this.produto = produtoPedido.getProduto();
        this.pedido = produtoPedido.getPedido();
    }

    public void validate() throws Exception {
        if (valorUnitario < 0) {
            throw new Exception("Valor unitário não deve ser negativo.");
        }

        if (quantidade <= 0) {
            throw new Exception("Quantidade não deve ser nulo ou negativo.");
        }
    }

    public ProdutoPedido build() throws Exception {
        validate();

        ProdutoPedido produtoPedido = new ProdutoPedido();
        produtoPedido.setValorUnitario(valorUnitario);
        produtoPedido.setQuantidade(quantidade);
        produtoPedido.setProduto(produto);
        produtoPedido.setPedido(pedido);

        return produtoPedido;
    }
    public ProdutoPedido build(ProdutoPedido produtoPedido) throws Exception {
        validate();

        produtoPedido.setValorUnitario(valorUnitario);
        produtoPedido.setQuantidade(quantidade);
        produtoPedido.setProduto(produto);
        produtoPedido.setPedido(pedido);

        return produtoPedido;
    }
}
