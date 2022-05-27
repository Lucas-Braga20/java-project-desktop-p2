package br.unigran.restaurante.app.repository;

import br.unigran.restaurante.app.builder.CargoBuilder;
import br.unigran.restaurante.app.casouso.CargoUC;
import br.unigran.restaurante.app.models.Cargo;

public class TesteDAO {
    public void testeSalvar() {
        CargoBuilder cargoBuilder = new CargoBuilder("Descrição teste");
        try {
            new CargoUC().salvar(cargoBuilder);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testeListarTodos() {
        try {
            new CargoUC().listarTodos();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testeAtualizar() {
        CargoBuilder cargoBuilder;
        Cargo cargo;
        try {
            cargo = new CargoUC().consultarPorId(1);
            cargoBuilder = new CargoBuilder("Descrição atualizada");
            new CargoUC().atualizar(cargoBuilder, cargo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testeRemover() {
        try {
            new CargoUC().remover(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new TesteDAO().testeRemover();
    }
}
