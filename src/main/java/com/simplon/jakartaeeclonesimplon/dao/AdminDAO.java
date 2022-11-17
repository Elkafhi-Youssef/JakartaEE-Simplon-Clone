package com.simplon.jakartaeeclonesimplon.dao;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.dao.entity.Admins;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AdminDAO implements DAO<Admins>{
    Admins admin;
    @Override
    public Admins getById(int id) {
        return null;
    }

    @Override
    public List<Admins> getAll() {
        return null;
    }

    @Override
    public boolean saveItem(Admins admins) {
        return false;
    }

    @Override
    public void updateItem(Admins admins, String[] params) {

    }

    @Override
    public void delete(Admins admins) {

    }
    public Admins getByEmail(String email) {
        EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
        TypedQuery<Admins> query = em.createQuery("SELECT a FROM Admins a WHERE a.email = ?1", Admins.class);
        query.setParameter(1,email);
        this.admin = new Admins();
        this.admin  = query.getSingleResult();
        System.out.println(admin.toString());
        return  this.admin;
    }
}
