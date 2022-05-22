package br.unigran.restaurante.app.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SingletonDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction etx;
    private static SingletonDao dao;
    
    private SingletonDao() {
        emf = Persistence.createEntityManagerFactory(
            "br.unigran_restaurant-app_jar_1.0-SNAPSHOTPU"
        );
        em = emf.createEntityManager();
        etx = em.getTransaction();
    }
    
    public static SingletonDao getInstance() {
        if (dao == null) {
            dao = new SingletonDao();
        }
        return dao;
    }
    
    public EntityManager getEM() {
        return em;
    }
    
    public EntityTransaction getTX() {
        return etx;
    }
}
