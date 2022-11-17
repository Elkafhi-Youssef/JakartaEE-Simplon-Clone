package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.dao.PromoDAO;
import com.simplon.jakartaeeclonesimplon.dao.entity.Promos;

import java.util.ArrayList;
import java.util.List;

public class PromoService {
    public Promos promo;
    public PromoDAO promoDAO;
    protected  List<Promos> promos = new ArrayList<Promos>();

    public PromoService() {
        this.promoDAO=  new PromoDAO();
    }
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
    public List<Promos> getAllPromos(){
        this.promos  = promoDAO.getAll();
        return this.promos;

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
    public int getPromoOfTrainer(int id){
        System.out.println("in the getPromoOfTrainer function ");
        this.promo = this.promoDAO.getById(id);
        int promoId = this.promo.getPromoId();
        System.out.println("id promo getPromoOfTrainer "+promoId);
        return promoId;
    }

}
