package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.CargoPapel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CargoDAO {
    public void remover(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            Cargo cargo = em.find(Cargo.class, id);
            if (cargo == null) {
                throw new Exception("Não foi possível remover um cargo com esse id.");
            }
            etx.begin();
            em.createQuery(
                "UPDATE Funcionario SET cargo.id = null WHERE cargo.id = :cargoId"
            ).setParameter("cargoId", cargo.getId()).executeUpdate();
            em.createQuery(
                "DELETE FROM CargoPapel WHERE cargoid = :cargoId"
            ).setParameter("cargoId", cargo.getId()).executeUpdate();
            em.remove(cargo);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw e;
        }
    }
}
