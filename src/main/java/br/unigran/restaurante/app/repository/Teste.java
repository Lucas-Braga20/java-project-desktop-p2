package br.unigran.restaurante.app.repository;

import br.unigran.restaurante.app.casouso.CargoUC;

public class Teste {
    public static void main(String[] args) {
        try {
            new CargoUC().listarTodos();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
