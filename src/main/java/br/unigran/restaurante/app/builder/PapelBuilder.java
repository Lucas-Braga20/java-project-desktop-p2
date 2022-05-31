package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Papel;

public class PapelBuilder {
    private String descricao;
    private Integer numero;

    public PapelBuilder(String descricao, Integer numero) {
        this.descricao = descricao;
        this.numero = numero;
    }
    public PapelBuilder(Papel papel) {
        this.descricao = papel.getDescricao();
    }

    public void validate() throws Exception {
        if (descricao.isEmpty() || descricao.isBlank()) {
            throw new Exception("Descrição não pode ser vazia.");
        }
        
        if (numero == null) {
            throw new Exception("Número não pode ser nulo.");
        }
    }

    public Papel build() throws Exception {
        validate();

        Papel papel = new Papel();
        papel.setDescricao(descricao);
        papel.setNumero(numero);

        return papel;
    }
    public Papel build(Papel papel) throws Exception {
        validate();

        papel.setDescricao(descricao);
        papel.setNumero(numero);

        return papel;
    }
}
