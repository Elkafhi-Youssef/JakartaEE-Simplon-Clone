package com.simplon.jakartaeeclonesimplon.controller;

import com.simplon.jakartaeeclonesimplon.dao.entity.Briefs;
import com.simplon.jakartaeeclonesimplon.dao.entity.Promos;
import com.simplon.jakartaeeclonesimplon.dao.entity.Students;
import com.simplon.jakartaeeclonesimplon.dao.entity.Trainers;
import com.simplon.jakartaeeclonesimplon.entity.*;
import com.simplon.jakartaeeclonesimplon.service.PromoService;
import com.simplon.jakartaeeclonesimplon.service.StudentService;
import com.simplon.jakartaeeclonesimplon.service.TrainerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/TrainerServlet/Trainers","/TrainerServlet/AddTrainer", "/TrainerServlet/AssignTrainer","/TrainerServlet","/TrainerServlet/getAllStudentByTrainer","/TrainerServlet/OwnStudent", "/TrainerServlet/AddBrief"})
public class TrainerServlet extends HttpServlet {
    private String url;
    TrainerService trainerService;
    StudentService studentService;
    public  PromoService promoService;
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
        }else if(requestedUrl.equals(this.url+"TrainerServlet/getAllStudentByTrainer")){
            this.studentService = new StudentService();
            List<Students> students = new ArrayList<Students>();
            students = studentService.getAllStudentsWithNoPromo();
            for (Students student : students) {
                System.out.println("test"+student.getStudentId());
            }
            request.setAttribute("studentsList", students);
            request.getRequestDispatcher("/trainer/trainerStudents.jsp").forward(request, response);
        }
        else if(requestedUrl.equals(this.url+"TrainerServlet/OwnStudent")){
            this.studentService = new StudentService();
            List<Students> students = new ArrayList<Students>();
            /*
            we want to create a function that help us to get all students of the promo of the trainer
            -first we have to get the promo id of the Trainer login
            -then we can get all students promo

             */
            /*
            get promoId by id trainer in the session
             */
            HttpSession session = request.getSession();
            int trainerId  = (int) session.getAttribute("trainerId");
            this.promoService  = new PromoService();
            int promoId = this.promoService.getPromoOfTrainer(trainerId);
            System.out.println("promo id "+ promoId);

            students = studentService.getAllStudentsByIdPromo(promoId);
            for (Students student : students) {
                System.out.println(student.getStudentId());
            }
            request.setAttribute("studentsList", students);
            request.getRequestDispatcher("/trainer/trainerHome.jsp").forward(request, response);
        }
        else if(requestedUrl.equals(this.url+"TrainerServlet/AddBrief")){
            HttpSession session = request.getSession();
            int trainerId  = (int) session.getAttribute("trainerId");
            this.promoService  = new PromoService();
            int promoId = this.promoService.getPromoOfTrainer(trainerId);
            request.setAttribute("promoId",promoId);
            request.getRequestDispatcher("/trainer/addBrief.jsp").forward(request, response);
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
                        session.setAttribute("trainerName", logTrainer.getUsername());
                        session.setAttribute("trainerId", logTrainer.getTrainerId());
                        System.out.println(logTrainer.getTrainerId());
                        if (logTrainer.getPromosByTrainerId().size() > 0) {
                            session.setAttribute("promoTrainer", ((List<Promos>)(logTrainer.getPromosByTrainerId())).get(0).getPromoName());
                        }else {
                            System.out.println("has no promosList");
                        }
                        response.sendRedirect("TrainerServlet/OwnStudent");
                    } else {
                        System.out.println("error: " + result);
                        request.getRequestDispatcher("admin/loginAdmin.jsp").forward(request, response);
                    }
                }
                case "AssignStudentToPromo"  -> {
                    int studentId = Integer.parseInt(request.getParameter("studentId"));
                    HttpSession session = request.getSession();
                    int trainerId  = (int) session.getAttribute("trainerId");
                    // function that help us to get promo id of trainer by trainer id
                    this.promoService  = new PromoService();
                    int promoId = this.promoService.getPromoOfTrainer(trainerId);
                    System.out.println("promo id "+ promoId);
                    //funtion that get student by id
                    this.studentService = new StudentService();
                    Students student = this.studentService.getStudentById(studentId);
                    student.setPromoId(promoId);
                    // function that update the promoId in the student table
                    String result = this.studentService.assignStudentPromo(student);
                    System.out.println(result);


                    System.out.println( "im in AssignStidentToPromo");
                }
                case "AddBrief"  -> {
                    Briefs brief = new Briefs();
                    HttpSession session = request.getSession();
                    brief.setBriefTitle(request.getParameter("title"));
                    brief.setDateStarted((request.getParameter("dates")));
                    brief.setDateEnd((request.getParameter("datee")));
                    brief.setDescription(request.getParameter("desc"));
//                    brief.setTrainerId((int) session.getAttribute("trainerId"));
                    brief.setTrainerId(4);
                    brief.setPromoId(Integer.parseInt(request.getParameter("promoId")));
                    System.out.println("brief :" + brief.toString());
                    TrainerService trainerService = new TrainerService();
                    String result = trainerService.addBrief(brief);
                    if (result.equals("success")) System.out.println("result :" + result);
                }

            }
        }
    }
}
