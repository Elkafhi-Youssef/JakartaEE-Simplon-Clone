package com.simplon.jakartaeeclonesimplon.controller;

import com.simplon.jakartaeeclonesimplon.entity.Promos;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import com.simplon.jakartaeeclonesimplon.entity.Trainers;
import com.simplon.jakartaeeclonesimplon.service.StudentService;
import com.simplon.jakartaeeclonesimplon.service.TrainerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/TrainerServlet/Trainers","/TrainerServlet/AddTrainer"})
public class TrainerServlet extends HttpServlet {
    private String url;
    TrainerService trainerService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.url = config.getServletContext().getInitParameter("url");
        this.trainerService  = new TrainerService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedUrl = request.getRequestURL().toString();
        if(requestedUrl.equals(this.url+"TrainerServlet/Trainers")){
            List<Trainers> trainers = new ArrayList<Trainers>();
            trainers = this.trainerService.getAllTrainers();
            request.setAttribute("trainersList", trainers);
            request.getRequestDispatcher("/admin/trainers.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
