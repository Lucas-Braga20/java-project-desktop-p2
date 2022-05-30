package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.CargoBuilder;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.persistence.DAO;

public class CargoUC {
    public Cargo salvar(CargoBuilder cargoBuilder) throws Exception {
        Cargo cargo = cargoBuilder.build();
        cargo = new DAO<Cargo>().salvar(cargo, Cargo.class, cargo.getId());

        return cargo;
    }

    public Cargo atualizar(CargoBuilder cargoBuilder, Cargo cargo) throws Exception {
        Cargo cargoAnterior = cargoBuilder.build(cargo);
        Cargo cargoAtualizado = new DAO<Cargo>().salvar(cargoAnterior, Cargo.class, cargoAnterior.getId());

        return cargoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new DAO<Cargo>().remover(id, Cargo.class);
    }

    public List<Cargo> listarTodos() throws Exception {
        List<Cargo> cargos = new DAO<Cargo>().listarTodos(Cargo.class);

        return cargos;
    }

    public Cargo consultarPorId(Integer id) throws Exception {
        Cargo cargo = new DAO<Cargo>().consultarPorId(id, Cargo.class);

        return cargo;
    }
}
