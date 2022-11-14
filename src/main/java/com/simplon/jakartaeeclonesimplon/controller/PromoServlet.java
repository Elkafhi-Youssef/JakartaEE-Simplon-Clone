package com.simplon.jakartaeeclonesimplon.controller;

import com.simplon.jakartaeeclonesimplon.entity.Promos;
import com.simplon.jakartaeeclonesimplon.service.PromoService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/PromoServlet/Promos","/PromoServlet/AddPromo"})
public class PromoServlet extends HttpServlet {
    private PromoService promoService;
    private String url;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.url = config.getServletContext().getInitParameter("url");
        this.promoService  = new PromoService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedUrl = request.getRequestURL().toString();
        if(requestedUrl.equals(this.url+"PromoServlet/Promos")) {
            List<Promos> promos = new ArrayList<Promos>();
            promos = this.promoService.getAllPromos();
            for (Promos p : promos) {
                System.out.println(p.getPromoId());
                System.out.println(p.getPromoName());
                if (p.getTrainersByTrainerId() !=null){
                    System.out.println(p.getTrainersByTrainerId().getUsername());
                }
                System.out.println(p.getCreatedOn());
            }
            request.setAttribute("promosList", promos);
            request.getRequestDispatcher("/admin/promos.jsp").forward(request, response);
        }else if(requestedUrl.equals(this.url+"PromoServlet/AddPromo")){
            request.getRequestDispatcher("/admin/addPromo.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
