package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProdutoDAO {
    public Produto salvar(Produto produto) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            etx.begin();
            if (produto.getId() == null) {
                em.persist(produto);
            } else {
                if (!em.contains(produto)) {
                    if (em.find(Produto.class, produto.getId()) == null) {
                        throw new Exception("Erro ao atualizar o produto");
                    }
                }
                produto = em.merge(produto);
            }
            etx.commit();
        } catch(Exception e) {
            etx.rollback();
            throw e;
        }

        return produto;
    }

    public void remover(Long id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            Produto produto = em.find(Produto.class, id);
            if (produto == null) {
                throw new Exception("Não foi possível remover um produto com esse id.");
            }
            etx.begin();
            em.remove(produto);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Produto> listarTodos() throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        List<Produto> produtos = null;

        try {
            produtos = em.createQuery("FROM Produto p").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return produtos;
    }

    public Produto consultarPorId(Long id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        Produto produto = null;

        try {
            produto = em.find(Produto.class, id);
            if (produto == null) {
                throw new Exception("Não foi possível achar um produto com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return produto;
    }
}
