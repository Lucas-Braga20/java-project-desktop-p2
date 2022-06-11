package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Mesa;

public class MesaBuilder {
    private Boolean ocupada;
    private Integer numero;

    public MesaBuilder(Boolean ocupada, Integer numero) {
        this.ocupada = ocupada;
        this.numero = numero;
    }

    public void validate() throws Exception {
        if (ocupada == null) {
            throw new Exception("Flag ocupada não pode ser nula.");
        }
        
        if (numero == null) {
            throw new Exception("Numero não pode ser nulo.");
        }
    }

    public Mesa build() throws Exception {
        validate();

        Mesa mesa = new Mesa();
        mesa.setOcupada(ocupada);
        mesa.setNumero(numero);

        return mesa;
    }
    public Mesa build(Mesa mesa) throws Exception {
        validate();

        mesa.setOcupada(ocupada);
        mesa.setNumero(numero);

        return mesa;
    }
}
