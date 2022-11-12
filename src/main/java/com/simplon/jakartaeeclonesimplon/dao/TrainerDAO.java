package com.simplon.jakartaeeclonesimplon.dao;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.entity.Promos;
import com.simplon.jakartaeeclonesimplon.entity.Trainers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TrainerDAO implements DAO<Trainers> {
    @Override
    public Trainers getById(int id) {
        return null;
    }

    @Override
    public List<Trainers> getAll() {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Trainers> query = em.createQuery("SELECT t FROM Trainers t", Trainers.class);
            List<Trainers> trainersListList = query.getResultList();
            em.getTransaction().commit();
            return trainersListList;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean saveItem(Trainers trainer) {
        trainer.toString();
        try {
            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(trainer );
            em.getTransaction().commit();
            return  true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public void updateItem(Trainers trainers, String[] params) {

    }

    @Override
    public void delete(Trainers trainers) {

    }
}
