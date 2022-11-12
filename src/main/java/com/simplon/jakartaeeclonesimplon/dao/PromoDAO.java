package com.simplon.jakartaeeclonesimplon.dao;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.entity.Promos;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PromoDAO implements DAO<Promos>{
    @Override
    public Promos getById(int promoId) {
        try{
            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            return em.find(Promos.class, promoId);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Promos> getAll() {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Promos> query = em.createQuery("SELECT p FROM Promos p", Promos.class);
            List<Promos> promosList = query.getResultList();
            em.getTransaction().commit();
            return promosList;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean saveItem(Promos promo) {
        try {
            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(promo);
            em.getTransaction().commit();
            return  true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void updateItem(Promos promos, String[] params) {

    }

    @Override
    public void delete(Promos promos) {

    }
    public boolean assignTrainerToPromo(Promos promo){
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.merge(promo);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
