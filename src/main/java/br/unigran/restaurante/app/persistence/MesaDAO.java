package br.unigran.restaurante.app.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unigran.restaurante.app.models.Mesa;

public class MesaDAO {
    public Mesa salvar(Mesa mesa) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            etx.begin();
            if (mesa.getId() == null) {
                em.persist(mesa);
            } else {
                if (!em.contains(mesa)) {
                    if (em.find(Mesa.class, mesa.getId()) == null) {
                        throw new Exception("Erro ao atualizar a mesa.");
                    }
                }
                mesa = em.merge(mesa);
            }
            etx.commit();
        } catch(Exception e) {
            etx.rollback();
            throw e;
        }
        
        return mesa;
    }

    public void remover(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            Mesa mesa = em.find(Mesa.class, id);
            if (mesa == null) {
                throw new Exception("Não foi possível remover uma mesa com esse id.");
            }
            etx.begin();
            em.remove(mesa);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Mesa> listarTodos() throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<Mesa> mesas = null;

        try {
            mesas = em.createQuery("FROM Mesa m").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return mesas;
    }

    public Mesa consultarPorId(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        Mesa mesa = null;

        try {
            mesa = em.find(Mesa.class, id);
            if (mesa == null) {
                throw new Exception("Não foi possível achar uma mesa com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return mesa;
    }
}
