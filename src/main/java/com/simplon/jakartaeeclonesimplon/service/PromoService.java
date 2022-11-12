package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.dao.PromoDAO;
import com.simplon.jakartaeeclonesimplon.entity.Promos;

import java.util.ArrayList;
import java.util.List;

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
    public void getPromos(){
        List<Promos> promos = new ArrayList<Promos>();
        promos  = promoDAO.getAll();
        System.out.println("list of promos");
        for (Promos promo: promos) {
            System.out.println(promos.toString());
        }
        System.out.println("end of list of promos");
    }
    public Promos getPromoById(int id){
        promo  = new Promos();
       promo =  promoDAO.getById(id);
       return promo;
    }
    public String assignTrainerToPromo( Promos promo){
        String message ;
        if(promoDAO.assignTrainerToPromo(promo)){
            message = "success";
        }else{
            message = "error";
        }
        return message;
    }

}
