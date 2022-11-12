package com.simplon.jakartaeeclonesimplon.controller;

import com.simplon.jakartaeeclonesimplon.entity.Admins;
import com.simplon.jakartaeeclonesimplon.entity.Students;
import com.simplon.jakartaeeclonesimplon.service.AdminService;
import com.simplon.jakartaeeclonesimplon.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    String message ;

    @Override
    public void init() throws ServletException {
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
                        request.getRequestDispatcher("admin/dashboard.jsp").forward(request, response);
                    }else {
                        System.out.println("error: " + result);
                        request.getRequestDispatcher("admin/loginAdmin.jsp").forward(request, response);
                    }
                }
                case "logoutAdmin"  -> {
                    HttpSession session = request.getSession();
                    session.removeAttribute("adminName");
                    request.getRequestDispatcher("admin/loginAdmin.jsp").forward(request, response);
                }
            }

        }
    }
}
