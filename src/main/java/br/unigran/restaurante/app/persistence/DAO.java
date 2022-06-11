package br.unigran.restaurante.app.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAO<T> {
    public T salvar(T objeto, Class<T> classe, Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            etx.begin();
            if (id == null) {
                em.persist(objeto);
            } else {
                if (!em.contains(objeto)) {
                    if (em.find(classe, id) == null) {
                        throw new Exception("Erro ao atualizar: " + classe.getSimpleName());
                    }
                }
                objeto = em.merge(objeto);
            }
            etx.commit();
        } catch(Exception e) {
            throw e;
        }
        
        return objeto;
    }

    public void remover(Integer id, Class<T> classe) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            T objeto = em.find(classe, id);
            if (objeto == null) {
                throw new Exception("Não foi possível remover um " + classe.getSimpleName() + " com esse id.");
            }
            etx.begin();
            em.remove(objeto);
            etx.commit();
        } catch (Exception e) {
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> listarTodos(Class<T> classe) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<T> objetos = null;

        try {
            objetos = em.createQuery("FROM " + classe.getSimpleName() + " o ").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return objetos;
    }

    public T consultarPorId(Integer id, Class<T> classe) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        T objeto = null;

        try {
            objeto = em.find(classe, id);
            if (objeto == null) {
                throw new Exception("Não foi possível achar um " + classe.getSimpleName() + " com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return objeto;
    }
}
