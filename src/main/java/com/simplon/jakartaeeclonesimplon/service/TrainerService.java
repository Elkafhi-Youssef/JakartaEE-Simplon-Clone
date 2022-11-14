package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.dao.StudentDAO;
import com.simplon.jakartaeeclonesimplon.dao.TrainerDAO;
import com.simplon.jakartaeeclonesimplon.entity.Promos;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import com.simplon.jakartaeeclonesimplon.entity.Trainers;

import java.util.ArrayList;
import java.util.List;

public class TrainerService {
    Trainers trainer;
    TrainerDAO trainertDAO  = new TrainerDAO();
    List<Trainers> trainers = new ArrayList<Trainers>();
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
    public void getTrainers(){
        List<Trainers> trainers = new ArrayList<Trainers>();
        trainers  = trainertDAO.getAll();
        System.out.println("list of trainers");
        for (Trainers trainer :trainers) {
            System.out.println(trainer.getTrainerId());
            System.out.println(trainer.getUsername());
        }
        System.out.println("end of trainer");
    }
    public List<Trainers> getAllTrainers() {
        trainers =  trainertDAO.getAll();
        return trainers;
    }
}
