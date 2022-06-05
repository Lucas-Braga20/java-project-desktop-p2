/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.restaurante.app.persistence;

import br.unigran.restaurante.app.models.Mesa;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Lucas
 */
public class MesaDAO {
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
            etx.rollback();
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
            etx.rollback();
            throw e;
        }
    }
}
