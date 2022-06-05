package br.unigran.restaurante.app.repository;

import br.unigran.restaurante.app.casouso.PratoUC;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.models.Prato;
import br.unigran.restaurante.app.persistence.CargoDAO;
import br.unigran.restaurante.app.persistence.DAO;
import br.unigran.restaurante.app.persistence.IngredientePratoDAO;
import br.unigran.restaurante.app.telas.ingredienteprato.IngredientePratoListagem;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        try {
            Prato prato = new PratoUC().consultarPorId(201);
            new IngredientePratoListagem(new javax.swing.JFrame(), true, prato).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        /*
        try {
            List<Cargo> cargos = new CargoDAO().listarTodos();
            for (int i = 0; i < cargos.size(); i++) {
                System.out.println(cargos.get(i).toString());
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        */
    }
}
