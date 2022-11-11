package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.dao.StudentDAO;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;



public class StudentService {
    Students student;
    StudentDAO studentDAO;
    List<Students> students = new ArrayList<Students>();
    public StudentService(){
        studentDAO = new StudentDAO();
        student = new Students();
    }
    public String loginStudent(String email, String password) {
        String message ;
        student = studentDAO.getByEmail(email);
        if (student != null) {
            if (student.getPsswd().equals(password)) {
                message = "success";
            }else{
                message = "password is incorrect";
            }
        }else {
            message = "error";
        }
        return message;
    }
}