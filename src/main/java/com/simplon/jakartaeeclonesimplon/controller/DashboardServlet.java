package com.simplon.jakartaeeclonesimplon.controller;

import com.simplon.jakartaeeclonesimplon.dao.entity.Students;
import com.simplon.jakartaeeclonesimplon.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DashboardServlet", value = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService  = new StudentService();

        List<Students> students = new ArrayList<Students>();
        students = studentService.getAllStudents();
        for (Students student : students) {
            System.out.println(student.getStudentId());

        }
        request.setAttribute("studentsList", students);
        request.getRequestDispatcher("admin/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
