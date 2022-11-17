package com.simplon.jakartaeeclonesimplon.controller;

import com.simplon.jakartaeeclonesimplon.dao.entity.Admins;
import com.simplon.jakartaeeclonesimplon.dao.entity.Promos;
import com.simplon.jakartaeeclonesimplon.dao.entity.Students;
import com.simplon.jakartaeeclonesimplon.dao.entity.Trainers;
import com.simplon.jakartaeeclonesimplon.service.AdminService;
import com.simplon.jakartaeeclonesimplon.service.PromoService;
import com.simplon.jakartaeeclonesimplon.service.StudentService;
import com.simplon.jakartaeeclonesimplon.service.TrainerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    String message ;
    TrainerService trainerService;
    StudentService studentService;
    PromoService promoService;

    @Override
    public void init() throws ServletException {
        this.trainerService = new TrainerService();
        this.studentService = new StudentService();
        this.promoService = new PromoService();
        System.out.println("in admin servlet init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "loginAdmin"  -> {
                    Admins adm = new Admins();
                    adm.setEmail(request.getParameter("email"));
                    adm.setPsswd(request.getParameter("password"));
                    AdminService adminService = new AdminService();
                    String result = adminService.loginAdmin(adm);
                    System.out.println("check the value of the " + result);
                    Admins logAdmin;
                    if (result.equals("success")){
                        logAdmin = adminService.admin;
                        HttpSession session = request.getSession();
                        session.setAttribute("adminName",logAdmin.getUsername());
                        response.sendRedirect("DashboardServlet");
                    }else {
                        System.out.println("error: " + result);
                        request.getRequestDispatcher("admin/loginAdmin.jsp").forward(request, response);
                    }
                }
                case "logoutAdmin"  -> {
                    HttpSession session = request.getSession();
                    session.removeAttribute("adminName");
                    request.getRequestDispatcher("admin/dashboard.jsp").forward(request, response);

                }
                case "AddTrainer" -> {
                    Trainers trainer = new Trainers();
                    trainer.setEmail(request.getParameter("email"));
                    trainer.setPsswd(request.getParameter("password"));
                    trainer.setUsername(request.getParameter("username"));
                    this.message = this.trainerService.addTrainer(trainer);
                    if (this.message.equals("success")) {
                        response.sendRedirect("TrainerServlet/Trainers");
                    }
                }
                case "AddStudent"  -> {
                    Students student = new Students();
                    student.setEmail(request.getParameter("email"));
                    student.setPsswd(request.getParameter("password"));
                    student.setUsername(request.getParameter("username"));
                    this.message = this.studentService.addStudent(student);
                    if (this.message.equals("success")) {
                        response.sendRedirect("DashboardServlet");
                     }
                  }
                case "addPromo" -> {
                    Promos promo = new Promos();
                    promo.setPromoName(request.getParameter("promoname"));
                    promo.setCreatedOn(request.getParameter("created_on"));
                    this.message = this.promoService.addPromo(promo);
                    if (this.message.equals("success")){
                        response.sendRedirect("PromoServlet/Promos");

                    }
                }
                case "AssignTrainer" -> {
                    PromoService promoService = new PromoService();
                    TrainerService trainerService = new TrainerService();
                    Promos promo = new Promos();
                    int id = Integer.parseInt(request.getParameter("promo"));
                   promo =  this.promoService.getPromoById(id);
                    System.out.println(promo.toString());
                    System.out.println("choose the id trainer");
                    int idTrainer =Integer.parseInt(request.getParameter("promo"));
                    promo.setTrainerId(Integer.parseInt(request.getParameter("promo")));
                   String result =  promoService.assignTrainerToPromo(promo);
                   if (result.equals("success")){
                       response.sendRedirect("PromoServlet/Promos");
                   }
                }
            }

        }
    }
}
