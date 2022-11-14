package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.dao.StudentDAO;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import com.simplon.jakartaeeclonesimplon.entity.Trainers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;



public class StudentService {
    Students student;
    StudentDAO studentDAO = new StudentDAO();
    List<Students> students = new ArrayList<Students>();
    public StudentService(){
        studentDAO = new StudentDAO();
        student = new Students();
    }
    public List<Students> getAllStudents() {
        students = studentDAO.getAll();
        for (Students s : students){
            System.out.println(s.getStudentId());
            if (s.getPromosByPromoId() != null){
                System.out.println(s.getPromosByPromoId().getPromoName());
            }
        }
        return students;
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
    public String addStudent(Students student){
        String message ;
        boolean result  =studentDAO.saveItem(student);
        if (result == true){
            message = "success";
        }else {
            message = "error";
        }
        return message;
    }
}
