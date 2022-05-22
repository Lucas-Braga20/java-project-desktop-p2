package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Cargo;

public class CargoBuilder {
    private String descricao;

    public CargoBuilder(String descricao) {
        this.descricao = descricao;
    }

    public void validate() throws Exception {
        if (descricao.isBlank() || descricao.isEmpty()) {
            throw new Exception("Descrição não pode ser vazia.");
        }
    }

    public Cargo build() throws Exception {
        validate();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        return cargo;
    }
    public Cargo build(Cargo cargo) throws Exception {
        validate();

        cargo.setDescricao(descricao);

        return cargo;
    }
}
