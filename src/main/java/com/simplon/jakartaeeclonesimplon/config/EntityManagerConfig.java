package com.simplon.jakartaeeclonesimplon.config;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConfig {
    private EntityManagerFactory emf;
    private static EntityManagerConfig entityManagerConfig = new EntityManagerConfig();

    private EntityManagerConfig() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static EntityManagerConfig getInstance() {
        return entityManagerConfig;
    }
}

