package br.unigran.restaurante.app.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unigran.restaurante.app.models.Endereco;

public class EnderecoDAO {
    public Endereco salvar(Endereco endereco) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            etx.begin();
            if (endereco.getId() == null) {
                em.persist(endereco);
            } else {
                if (!em.contains(endereco)) {
                    if (em.find(Endereco.class, endereco.getId()) == null) {
                        throw new Exception("Erro ao atualizar o endereço.");
                    }
                }
                endereco = em.merge(endereco);
            }
            etx.commit();
        } catch(Exception e) {
            etx.rollback();
            throw e;
        }
        
        return endereco;
    }

    public void remover(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            Endereco endereco = em.find(Endereco.class, id);
            if (endereco == null) {
                throw new Exception("Não foi possível remover um endereço com esse id.");
            }
            etx.begin();
            em.remove(endereco);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Endereco> listarTodos() throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<Endereco> enderecos = null;

        try {
            enderecos = em.createQuery("FROM Endereco e").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return enderecos;
    }

    public Endereco consultarPorId(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        Endereco endereco = null;

        try {
            endereco = em.find(Endereco.class, id);
            if (endereco == null) {
                throw new Exception("Não foi possível achar um endereco com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return endereco;
    }
}
