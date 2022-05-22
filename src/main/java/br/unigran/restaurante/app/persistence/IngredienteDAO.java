package br.unigran.restaurante.app.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unigran.restaurante.app.models.Ingrediente;

public class IngredienteDAO {
    public Ingrediente salvar(Ingrediente ingrediente) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            etx.begin();
            if (ingrediente.getId() == null) {
                em.persist(ingrediente);
            } else {
                if (!em.contains(ingrediente)) {
                    if (em.find(Ingrediente.class, ingrediente.getId()) == null) {
                        throw new Exception("Erro ao atualizar a ingrediente");
                    }
                }
                ingrediente = em.merge(ingrediente);
            }
            etx.commit();
        } catch(Exception e) {
            etx.rollback();
            throw e;
        }
        
        return ingrediente;
    }

    public void remover(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            Ingrediente ingrediente = em.find(Ingrediente.class, id);
            if (ingrediente == null) {
                throw new Exception("Não foi possível remover um ingrediente com esse id.");
            }
            etx.begin();
            em.remove(ingrediente);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Ingrediente> listarTodos() throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<Ingrediente> ingredientes = null;

        try {
            ingredientes = em.createQuery("FROM Ingrediente i").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return ingredientes;
    }

    public Ingrediente consultarPorId(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        Ingrediente ingrediente = null;

        try {
            ingrediente = em.find(Ingrediente.class, id);
            if (ingrediente == null) {
                throw new Exception("Não foi possível achar um ingrediente com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return ingrediente;
    }
}
