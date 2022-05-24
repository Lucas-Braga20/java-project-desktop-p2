package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Pedido;
import br.unigran.restaurante.app.models.Prato;
import br.unigran.restaurante.app.models.PratoPedido;

public class PratoPedidoBuilder {
    private Integer quantidade;
    private Float valor;
    private Prato prato;
    private Pedido pedido;

    public PratoPedidoBuilder(Integer quantidade, Float valor, Prato prato, Pedido pedido) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.prato = prato;
        this.pedido = pedido;
    }

    public void validate() throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor não pode ser negativo ou nulo.");
        }

        if (quantidade <= 0) {
            throw new Exception("Quantidade não pode ser negativo ou nulo.");
        }
    }

    public PratoPedido build() throws Exception {
        validate();

        PratoPedido pratoPedido = new PratoPedido();
        pratoPedido.setPedido(pedido);
        pratoPedido.setPrato(prato);
        pratoPedido.setQuantidade(quantidade);
        pratoPedido.setValor(valor);

        return pratoPedido;
    }
}
