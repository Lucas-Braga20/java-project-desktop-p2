/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Lucas
 */
public class UsuarioDAO {
    public List<Funcionario> logar(String apelido, String senha) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();
        
        try {
            List<Funcionario> funcionario = em.createQuery(
                "FROM Funcionario f WHERE f.apelido = :apelido AND f.senha = :senha"
            ).setParameter("apelido", apelido).setParameter("senha", senha).getResultList();
            
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }
}
