package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Cargo;

public class CargoBuilder {
    private String descricao;
    private Integer numero;

    public CargoBuilder(String descricao, Integer numero) {
        this.descricao = descricao;
        this.numero = numero;
    }

    public void validate() throws Exception {
        if (descricao.isBlank() || descricao.isEmpty()) {
            throw new Exception("Descrição não pode ser vazia.");
        }
        
        if (numero == null) {
            throw new Exception("Número não pode ser nulo.");
        }
    }

    public Cargo build() throws Exception {
        validate();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargo.setNumero(numero);

        return cargo;
    }
    public Cargo build(Cargo cargo) throws Exception {
        validate();

        cargo.setDescricao(descricao);
        cargo.setNumero(numero);

        return cargo;
    }
}
