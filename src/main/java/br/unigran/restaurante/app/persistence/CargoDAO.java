package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.CargoPapel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CargoDAO {
    public Cargo salvar(Cargo cargo) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            etx.begin();
            if (cargo.getId() == null) {
                em.persist(cargo);
            } else {
                if (!em.contains(cargo)) {
                    if (em.find(Cargo.class, cargo.getId()) == null) {
                        throw new Exception("Erro ao atualizar a cargo");
                    }
                }
                cargo = em.merge(cargo);
            }
            etx.commit();
        } catch(Exception e) {
            etx.rollback();
            throw e;
        }
        
        return cargo;
    }

    public void remover(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            Cargo cargo = em.find(Cargo.class, id);
            if (cargo == null) {
                throw new Exception("Não foi possível remover um cargo com esse id.");
            }
            etx.begin();
            /*
            em.createQuery(
                "UPDATE Funcionario f SET f.cargoid = null WHERE f.cargoId = :cargoId"
            ).setParameter("cargoId", cargo.getId()).executeUpdate();
            */
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

    @SuppressWarnings("unchecked")
    public List<Cargo> listarTodos() throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<Cargo> cargos = null;

        try {
            cargos = em.createQuery("FROM Cargo c").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return cargos;
    }

    public Cargo consultarPorId(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        Cargo cargo = null;

        try {
            cargo = em.find(Cargo.class, id);
            if (cargo == null) {
                throw new Exception("Não foi possível achar um cargo com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return cargo;
    }
}
