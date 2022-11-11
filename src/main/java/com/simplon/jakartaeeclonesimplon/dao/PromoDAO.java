package com.simplon.jakartaeeclonesimplon.dao;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.entity.Promos;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PromoDAO implements DAO<Promos>{
    @Override
    public Promos getById(int id) {
        return null;
    }

    @Override
    public List<Promos> getAll() {
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
}
