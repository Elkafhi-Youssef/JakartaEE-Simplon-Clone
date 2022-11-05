package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Admins {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "admin_id")
    private int adminId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "psswd")
    private String psswd;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "admin_image")
    private String adminImage;
    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Basic
    @Column(name = "last_login")
    private Timestamp lastLogin;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminImage() {
        return adminImage;
    }

    public void setAdminImage(String adminImage) {
        this.adminImage = adminImage;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admins admins = (Admins) o;
        return adminId == admins.adminId && Objects.equals(username, admins.username) && Objects.equals(psswd, admins.psswd) && Objects.equals(email, admins.email) && Objects.equals(adminImage, admins.adminImage) && Objects.equals(createdOn, admins.createdOn) && Objects.equals(lastLogin, admins.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, username, psswd, email, adminImage, createdOn, lastLogin);
    }
}
