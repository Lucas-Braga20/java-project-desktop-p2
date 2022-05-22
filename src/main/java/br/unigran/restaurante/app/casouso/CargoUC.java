package br.unigran.restaurante.app.casouso;

import java.util.List;

import br.unigran.restaurante.app.builder.CargoBuilder;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.persistence.CargoDAO;

public class CargoUC {
    public Cargo salvar(CargoBuilder cargoBuilder) throws Exception {
        Cargo cargo = new CargoDAO().salvar(cargoBuilder.build());

        System.out.println(cargo.toString());

        return cargo;
    }

    public Cargo atualizar(CargoBuilder cargoBuilder, Cargo cargo) throws Exception {
        Cargo cargoAtualizado = new CargoDAO().salvar(cargoBuilder.build(cargo));

        System.out.println(cargoAtualizado.toString());

        return cargoAtualizado;
    }

    public void remover(Integer id) throws Exception {
        new CargoDAO().remover(id);
    }

    public List<Cargo> listarTodos() throws Exception {
        List<Cargo> cargos = new CargoDAO().listarTodos();

        for (int i = 0; i < cargos.size(); i++) {
            System.out.println(cargos.get(i).toString());
        }

        return cargos;
    }

    public Cargo consultarPorId(Integer id) throws Exception {
        Cargo cargo = new CargoDAO().consultarPorId(id);
        System.out.println(cargo.toString());
        return cargo;
    }
}
