package com.simplon.jakartaeeclonesimplon.service;

import com.simplon.jakartaeeclonesimplon.dao.AdminDAO;
import com.simplon.jakartaeeclonesimplon.entity.Admins;

public class AdminService {
    public   Admins admin = new Admins();
    AdminDAO adminDAO;
    public AdminService() {

    }



    public String loginAdmin(Admins admin) {
        String message ;
        this.adminDAO = new AdminDAO();
        String email =  admin.getEmail();
        this.admin = this.adminDAO.getByEmail(email);
        if (this.admin != null) {
            if (admin.getPsswd().equals(this.admin.getPsswd())) {
                message = "success";
            }else{
                message = "password is incorrect";
            }
        }else {
            message = "error";
        }
        return message;
    }

}
