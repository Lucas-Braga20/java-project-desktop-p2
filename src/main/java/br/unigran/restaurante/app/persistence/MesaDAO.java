/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.persistence.DAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Lucas
 */
public class MesaDAO extends DAO<Mesa> {
    @Override
    public Mesa salvar(Mesa mesa, Class classe, Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();

        try {
            List<Mesa> mesasEncontradas = em.createQuery(
                "FROM Mesa m WHERE m.numero = :mesaNumero"
            ).setParameter("mesaNumero", mesa.getNumero()).getResultList();
            if (mesasEncontradas.size() > 0) {
                if (mesasEncontradas.size() == 1) {
                    if (mesasEncontradas.get(0).getId() != id) {
                        throw new Exception("Uma mesa com esse número já existe.");
                    }
                } else {
                    throw new Exception("Uma mesa com esse número já existe.");
                }
            }
            
            etx.begin();
            if (id == null) {
                em.persist(mesa);
            } else {
                if (!em.contains(mesa)) {
                    if (em.find(classe, id) == null) {
                        throw new Exception("Erro ao atualizar: " + classe.getSimpleName());
                    }
                }
                mesa = em.merge(mesa);
            }
            etx.commit();
        } catch(Exception e) {
            throw e;
        }
        
        return mesa;
    }
    
    public List<Mesa> listarNaoOcupada() throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();
        List<Mesa> mesas = new ArrayList<Mesa>();
        
        try {
            mesas = em.createQuery(
                "FROM Mesa m WHERE m.ocupada = false"
            ).getResultList();
        } catch (Exception e) {
            throw e;
        }
        
        return mesas;
    }
    
    public void ocuparMesa(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();
        
        try {
            Mesa mesa = em.find(Mesa.class, id);
            if (mesa == null) {
                throw new Exception("Não foi possível achar uma mesa com esse id.");
            }
            if (mesa.getOcupada()) {
                throw new Exception("Mesa já está ocupada.");
            }
            mesa.setOcupada(true);
            etx.begin();
            em.merge(mesa);
            etx.commit();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void desocuparMesa(Integer id) throws Exception {
        EntityManager em = SingletonDao.getInstance().getEM();
        EntityTransaction etx = SingletonDao.getInstance().getTX();
        
        try {
            Mesa mesa = em.find(Mesa.class, id);
            if (mesa == null) {
                throw new Exception("Não foi possível achar uma mesa com esse id.");
            }
            if (mesa.getOcupada() == false) {
                throw new Exception("Mesa não está ocupada.");
            }
            mesa.setOcupada(false);
            etx.begin();
            em.merge(mesa);
            etx.commit();
        } catch (Exception e) {
            throw e;
        }
    }
}
