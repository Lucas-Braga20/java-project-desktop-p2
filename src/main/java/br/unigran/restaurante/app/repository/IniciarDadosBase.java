/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.restaurante.app.repository;

import br.unigran.restaurante.app.builder.CargoBuilder;
import br.unigran.restaurante.app.builder.CargoPapelBuilder;
import br.unigran.restaurante.app.builder.EnderecoBuilder;
import br.unigran.restaurante.app.builder.FuncionarioBuilder;
import br.unigran.restaurante.app.casouso.CargoPapelUC;
import br.unigran.restaurante.app.casouso.CargoUC;
import br.unigran.restaurante.app.casouso.FuncionarioUC;
import br.unigran.restaurante.app.enums.Cidade;
import br.unigran.restaurante.app.enums.Papel;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.Funcionario;
import br.unigran.restaurante.app.util.Util;
import java.util.Date;

/**
 *
 * @author Lucas
 */
public class IniciarDadosBase {
    public static void carregar() {
        try {
            CargoBuilder cargoBuilder = new CargoBuilder("Administração", 1);
            Cargo cargo = CargoUC.salvar(cargoBuilder);
            
            for (int i = 0; i < Papel.values().length; i++) {
                CargoPapelUC.salvar(new CargoPapelBuilder(Papel.values()[i], cargo));
            }
                        
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder(
                "Admin", new Date(), "123.456.789-10", cargo, null, "admin", Util.geraSenha("admin")
            );
            Funcionario funcionario = FuncionarioUC.salvar(funcionarioBuilder);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
