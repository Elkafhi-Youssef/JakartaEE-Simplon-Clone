package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.dao.PromoDAO;
import com.simplon.jakartaeeclonesimplon.entity.Promos;

public class PromoService {
    public Promos promo;
    public PromoDAO promoDAO=  new PromoDAO();

    public PromoService() {}
    public String addPromo(Promos promo){
        String message ;
        boolean result  =  promoDAO.saveItem(promo);
        if (result == true){
            message = "success";
        }else {
            message = "error";
        }
        return message;
    }
}
