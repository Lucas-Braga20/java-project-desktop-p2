package br.unigran.restaurante.app.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unigran.restaurante.app.models.Prato;

public class PratoDAO {
    public Prato salvar(Prato prato) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            etx.begin();
            if (prato.getId() == null) {
                em.persist(prato);
            } else {
                if (!em.contains(prato)) {
                    if (em.find(Prato.class, prato.getId()) == null) {
                        throw new Exception("Erro ao atualizar o prato.");
                    }
                }
                prato = em.merge(prato);
            }
            etx.commit();
        } catch(Exception e) {
            etx.rollback();
            throw e;
        }
        
        return prato;
    }

    public void remover(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            Prato prato = em.find(Prato.class, id);
            if (prato == null) {
                throw new Exception("Não foi possível remover um prato com esse id.");
            }
            etx.begin();
            em.remove(prato);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Prato> listarTodos() throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<Prato> pratos = null;

        try {
            pratos = em.createQuery("FROM Prato p").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return pratos;
    }

    public Prato consultarPorId(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        Prato prato = null;

        try {
            prato = em.find(Prato.class, id);
            if (prato == null) {
                throw new Exception("Não foi possível achar um prato com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return prato;
    }
}
