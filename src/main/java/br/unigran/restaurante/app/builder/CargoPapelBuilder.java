package br.unigran.restaurante.app.builder;

import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.CargoPapel;
import br.unigran.restaurante.app.enums.Papel;

public class CargoPapelBuilder {
    private Papel papel;
    private Cargo cargo;

    public CargoPapelBuilder(Papel papel, Cargo cargo) {
        this.papel = papel; 
        this.cargo = cargo;
    }
    
    public void validate() throws Exception {
        if (papel == null) {
            throw new Exception("Papel não pode ser nulo.");
        }
        
        if (cargo == null) {
            throw new Exception("Cargo não pode ser nulo.");
        }
    }

    public CargoPapel build() throws Exception {
        CargoPapel cargoPapel = new CargoPapel();
        cargoPapel.setCargo(cargo);
        cargoPapel.setPapel(papel);
        return cargoPapel;
    }
    public CargoPapel build(CargoPapel cargoPapel) throws Exception {
        cargoPapel.setCargo(cargo);
        cargoPapel.setPapel(papel);
        return cargoPapel;
    }
}
