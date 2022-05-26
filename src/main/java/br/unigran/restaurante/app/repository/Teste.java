package br.unigran.restaurante.app.repository;

import br.unigran.restaurante.app.persistence.DAO;
import java.util.List;
import br.unigran.restaurante.app.models.Cargo;

public class Teste {
    public static void main(String[] args) {
        /*
            CRIAÇÃO GENÉRICO

        Cargo cargoCriado = new Cargo();
        cargoCriado.setDescricao("Teste dao generico");

        DAO<Cargo> cargoDAO = new DAO<Cargo>();

        try {
            cargoDAO.salvar(cargoCriado, Cargo.class, cargoCriado.getId());
        } catch (Exception e) {
            System.out.println(e);
        }
        */



        /*
            CONSULTA GENÉRICO

        DAO<Cargo> cargoDAO = new DAO<Cargo>();
        try {
            Cargo cargoConsultado = cargoDAO.consultarPorId(801, Cargo.class);
            System.out.println(cargoConsultado.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        */



        /*
            CONSULTA TODOS

        DAO<Cargo> cargoDAO = new DAO<Cargo>();
        try {
            List<Cargo> cargosConsultados = cargoDAO.listarTodos(Cargo.class);
            for (int i = 0; i < cargosConsultados.size(); i++) {
                System.out.println(cargosConsultados.get(i).toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        */



        /*
            ATUALIZAR

        DAO<Cargo> cargoDAO = new DAO<Cargo>();
        Cargo cargoConsultado;
        try {
            cargoConsultado = cargoDAO.consultarPorId(801, Cargo.class);
            System.out.println(cargoConsultado.toString());

            cargoConsultado.setDescricao("Descrição DAO atualizado");

            cargoConsultado = cargoDAO.salvar(cargoConsultado, Cargo.class, cargoConsultado.getId());

            System.out.println(cargoConsultado.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        */



        /*
            DELETAR
        DAO<Cargo> cargoDAO = new DAO<Cargo>();
        Cargo cargoConsultado;
        try {
            cargoConsultado = cargoDAO.consultarPorId(801, Cargo.class);
            System.out.println(cargoConsultado.toString());

            cargoDAO.remover(cargoConsultado.getId(), Cargo.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        */
    }
}
