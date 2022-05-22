package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Mesa;

public class MesaBuilder {
    private Boolean ocupada;

    public MesaBuilder(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void validate() throws Exception {
        if (ocupada == null) {
            throw new Exception("Flag ocupada não pode ser nula.");
        }
    }

    public Mesa build() throws Exception {
        validate();

        Mesa mesa = new Mesa();
        mesa.setOcupada(ocupada);

        return mesa;
    }
    public Mesa build(Mesa mesa) throws Exception {
        validate();

        mesa.setOcupada(ocupada);

        return mesa;
    }
}
