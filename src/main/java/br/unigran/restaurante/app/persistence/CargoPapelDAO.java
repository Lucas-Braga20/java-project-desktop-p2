/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.CargoPapel;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Lucas
 */
public class CargoPapelDAO extends DAO<CargoPapel> {
    public List<CargoPapel> buscarPapeis(Cargo cargo) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<CargoPapel> cargoPapeis = null;

        try {
            cargoPapeis = em.createQuery(
                "FROM CargoPapel o WHERE o.cargo.id = :cargoId"
            ).setParameter("cargoId", cargo.getId()).getResultList();
        } catch (Exception e) {
            throw e;
        }
        
        return cargoPapeis;
    }
}
