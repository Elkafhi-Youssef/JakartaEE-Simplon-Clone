package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.config.EntityManagerConfig;
import com.simplon.jakartaeeclonesimplon.dao.StudentDAO;
import com.simplon.jakartaeeclonesimplon.entity.Promos;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import com.simplon.jakartaeeclonesimplon.entity.Trainers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;



public class StudentService {
    Students student;
    StudentDAO studentDAO ;
    List<Students> students = new ArrayList<Students>();
    public StudentService(){
        this.studentDAO = new StudentDAO();
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
    public List<Students> getAllStudentsWithNoPromo() {
        students = studentDAO.getAllStudentsWithNoPromo();
        for (Students s : students){
            System.out.println("test wax kayn ga3 student "+s.getStudentId());
            if (s.getPromosByPromoId() != null){
                System.out.println(s.getPromosByPromoId().getPromoName());
            }
        }
        return students;
    }
    public Students getStudentById(int studentId){
        this.student = this.studentDAO.getById(studentId);
        return this.student;
    }
    public String assignStudentPromo( Students student){
        String message ;
        if(this.studentDAO.assignStudentPromo(student)){
            message = "success";
        }else{
            message = "error";
        }
        return message;
    }
    public List<Students> getAllStudentsByIdPromo(int id) {
        students = studentDAO.getAllStudentsByIdPromo(id);
        for (Students s : students){
            System.out.println(s.getStudentId());
            if (s.getPromosByPromoId() != null){
                System.out.println(s.getPromosByPromoId().getPromoName());
            }
        }
        return students;
    }
}
