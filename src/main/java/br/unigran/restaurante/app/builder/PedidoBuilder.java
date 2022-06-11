package br.unigran.restaurante.app.builder;

import java.util.Date;

import br.unigran.restaurante.app.models.Cliente;
import br.unigran.restaurante.app.models.Funcionario;
import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.models.Pedido;

public class PedidoBuilder {
    private Float total;
    private Date data;
    private Boolean finalizado;
    private Cliente cliente;
    private Funcionario funcionario;
    private Mesa mesa;

    public PedidoBuilder(Float total, Date data, Boolean finalizado, Cliente cliente, Funcionario funcionario, Mesa mesa) {
        this.total = total;
        this.data = data;
        this.finalizado = finalizado;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.mesa = mesa;
    }

    public void validate() throws Exception {
        if (total <= 0) {
            throw new Exception("Total não pode ser negativo ou nulo.");
        }
        
        if (data == null) {
            throw new Exception("Data não pode ser nula.");
        }
        
        if (cliente == null) {
            throw new Exception("Cliente não pode ser nula.");
        }
        
        if (funcionario == null) {
            throw new Exception("Funcionário não pode ser nulo.");
        }
    }

    public Pedido build() throws Exception {
        validate();

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setData(data);
        pedido.setFinalizado(finalizado);
        pedido.setFuncionario(funcionario);
        pedido.setMesa(mesa);
        pedido.setTotal(total);

        return pedido;
    }
    public Pedido build(Pedido pedido) throws Exception {
        validate();

        pedido.setCliente(cliente);
        pedido.setData(data);
        pedido.setFinalizado(finalizado);
        pedido.setFuncionario(funcionario);
        pedido.setMesa(mesa);
        pedido.setTotal(total);

        return pedido;
    }
}
