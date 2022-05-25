package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Papel;

public class PapelBuilder {
    private String descricao;

    public PapelBuilder(String descricao) {
        this.descricao = descricao;
    }
    public PapelBuilder(Papel papel) {
        this.descricao = papel.getDescricao();
    }

    public void validate() throws Exception {
        if (descricao.isEmpty() || descricao.isBlank()) {
            throw new Exception("Descrição não pode ser vazia.");
        }
    }

    public Papel build() throws Exception {
        validate();

        Papel papel = new Papel();
        papel.setDescricao(descricao);

        return papel;
    }
    public Papel build(Papel papel) throws Exception {
        validate();

        papel.setDescricao(descricao);

        return papel;
    }
}
