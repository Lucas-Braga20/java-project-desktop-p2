package br.unigran.restaurante.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class Dao {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction etx;
    
    private static void inicio(){
        if (em == null){
            emf = Persistence.createEntityManagerFactory("br.unigran_restaurant-app_jar_1.0-SNAPSHOTPU");
            em = emf.createEntityManager();
            etx = em.getTransaction();
        }
    }
    public static EntityManager getEm(){
        inicio();
        return em;
    }
    public static Object save(Object o){
        inicio();
        
        etx.begin();
        Object salvo = em.merge(o);
        etx.commit();
        return salvo;
    }
    public static void remove(Object o){
        inicio();
        
        etx.begin();
        em.remove(o);
        etx.commit();
    }
    
    public static void main(String[] args) {
        inicio();
    }
}
