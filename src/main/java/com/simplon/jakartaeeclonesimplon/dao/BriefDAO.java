package com.simplon.jakartaeeclonesimplon.dao;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.dao.entity.Briefs;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BriefDAO implements DAO<Briefs> {
    @Override
    public Briefs getById(int id) {
        return null;
    }

    @Override
    public List<Briefs> getAll() {
        return null;
    }

    @Override
    public boolean saveItem(Briefs brief) {
        System.out.println("data of brief are" +brief.toString());
        try {
            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(brief);
            em.getTransaction().commit();
            return  true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void updateItem(Briefs briefs, String[] params) {

    }

    @Override
    public void delete(Briefs briefs) {

    }
}
