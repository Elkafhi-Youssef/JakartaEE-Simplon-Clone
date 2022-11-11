package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.dao.StudentDAO;
import com.simplon.jakartaeeclonesimplon.dao.TrainerDAO;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import com.simplon.jakartaeeclonesimplon.entity.Trainers;

import java.util.ArrayList;
import java.util.List;

public class TrainerService {
    Trainers trainer;
    TrainerDAO trainertDAO  = new TrainerDAO();
    List<Trainers> students = new ArrayList<Trainers>();
    public String addTrainer(Trainers trainer){
    String message ;
    boolean result  =  trainertDAO.saveItem(trainer);
    if (result == true){
        message = "success";
    }else {
        message = "error";
    }
    return message;
    }
}
