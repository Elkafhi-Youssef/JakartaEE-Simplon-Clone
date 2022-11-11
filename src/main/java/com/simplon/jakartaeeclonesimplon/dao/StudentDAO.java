package com.simplon.jakartaeeclonesimplon.dao;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements DAO<Students> {
    Students student = new Students();
    public StudentDAO() {

    }

    @Override
    public Students getById(int id) {
        return null;
    }

    @Override
    public List<Students> getAll() {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Students> query = em.createQuery("SELECT s FROM Students s", Students.class);
            List<Students> StudentsList = query.getResultList();
            em.getTransaction().commit();
            return StudentsList;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean saveItem(Students students) {
    return false;
    }

    @Override
    public void updateItem(Students students, String[] params) {

    }

    @Override
    public void delete(Students students) {

    }
    public Students loginStudent(int  id) {
        System.out.println("html 7aja  eclones" );
        Students  info = new Students();
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            info = em.find(Students.class, id);
            if (info == null){
                System.out.println("no data found");
            }else {
                info.toString();
                return info;
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Students getByEmail(String email) {
        EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
        TypedQuery<Students> query = em.createQuery("SELECT a FROM Students a WHERE a.email = ?1", Students.class);
        query.setParameter(1,email);
        this.student  = query.getSingleResult();
        System.out.println(student.toString());
        return  this.student;
    }
}
