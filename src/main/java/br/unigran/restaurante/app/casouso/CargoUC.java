package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.CargoBuilder;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.persistence.CargoDAO;
import br.unigran.restaurante.app.persistence.DAO;

public final class CargoUC {
    private static CargoDAO DAO = new CargoDAO();
    
    public static Cargo salvar(CargoBuilder cargoBuilder) throws Exception {
        Cargo cargo = cargoBuilder.build();
        cargo = DAO.salvar(cargo, Cargo.class, cargo.getId());
        return cargo;
    }

    public static Cargo atualizar(CargoBuilder cargoBuilder, Cargo cargo) throws Exception {
        Cargo cargoAnterior = cargoBuilder.build(cargo);
        Cargo cargoAtualizado = DAO.salvar(cargoAnterior, Cargo.class, cargoAnterior.getId());
        return cargoAtualizado;
    }

    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Cargo.class);
    }

    public static List<Cargo> listarTodos() throws Exception {
        List<Cargo> cargos = DAO.listarTodos(Cargo.class);
        return cargos;
    }

    public static Cargo consultarPorId(Integer id) throws Exception {
        Cargo cargo = DAO.consultarPorId(id, Cargo.class);
        return cargo;
    }
}
