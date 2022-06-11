package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Cargo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.unigran.restaurante.app.persistence.DAO;

public class CargoDAO extends DAO<Cargo> {
    @Override
    public Cargo salvar(Cargo cargo, Class classe, Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();
        
        try {
            List<Cargo> cargosEncontrado = em.createQuery(
                "FROM Cargo c WHERE c.numero = :cargoNumero"
            ).setParameter("cargoNumero", cargo.getNumero()).getResultList();
            if (cargosEncontrado.size() > 0) {
                if (cargosEncontrado.size() == 1) {
                    if (cargosEncontrado.get(0).getId() != id) {
                        throw new Exception("Um cargo com esse número já existe.");
                    }
                } else {
                    throw new Exception("Um cargo com esse número já existe.");
                }
            }
            
            etx.begin();
            if (id == null) {
                em.persist(cargo);
            } else {
                if (!em.contains(cargo)) {
                    if (em.find(classe, id) == null) {
                        throw new Exception("Erro ao atualizar: " + classe.getSimpleName());
                    }
                }
                cargo = em.merge(cargo);
            }
            etx.commit();
        } catch(Exception e) {
            throw e;
        }
        
        return cargo;
    }
}
