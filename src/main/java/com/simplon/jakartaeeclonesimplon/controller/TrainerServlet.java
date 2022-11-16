package com.simplon.jakartaeeclonesimplon.controller;

import com.simplon.jakartaeeclonesimplon.entity.Admins;
import com.simplon.jakartaeeclonesimplon.entity.Promos;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import com.simplon.jakartaeeclonesimplon.entity.Trainers;
import com.simplon.jakartaeeclonesimplon.service.AdminService;
import com.simplon.jakartaeeclonesimplon.service.PromoService;
import com.simplon.jakartaeeclonesimplon.service.StudentService;
import com.simplon.jakartaeeclonesimplon.service.TrainerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/TrainerServlet/Trainers","/TrainerServlet/AddTrainer", "/TrainerServlet/AssignTrainer","/TrainerServlet"})
public class TrainerServlet extends HttpServlet {
    private String url;
    TrainerService trainerService;
    private PromoService promoService;
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
        }else if (requestedUrl.equals(this.url+"TrainerServlet/AddTrainer")){
            request.getRequestDispatcher("/admin/addTrainer.jsp").forward(request, response);
        }else  if (requestedUrl.equals(this.url+"TrainerServlet/AssignTrainer")){
            List<Trainers> trainers = new ArrayList<Trainers>();
            trainers = this.trainerService.getAllTrainers();
            request.setAttribute("trainersList", trainers);
            this.promoService  = new PromoService();
            List<Promos> promos = new ArrayList<Promos>();
            promos = this.promoService.getAllPromos();
            request.setAttribute("promosList", promos);
            request.getRequestDispatcher("/admin/assignTrainer.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "loginTrainer" -> {
                    Trainers trainer = new Trainers();
                    trainer.setEmail(request.getParameter("email"));
                    trainer.setPsswd(request.getParameter("password"));
                    TrainerService trainerService = new TrainerService();
                    String result = trainerService.loginTrainer(trainer);
                    System.out.println("check the value of the " + result);
                    Trainers logTrainer;
                    if (result.equals("success")) {
                        logTrainer = trainerService.trainer;
                        HttpSession session = request.getSession();
                        session.setAttribute("adminName", logTrainer.getUsername());
                        request.getRequestDispatcher("trainer/trainerHome.jsp").forward(request, response);
                    } else {
                        System.out.println("error: " + result);
                        request.getRequestDispatcher("admin/loginAdmin.jsp").forward(request, response);
                    }
                }
            }
        }
    }
}
