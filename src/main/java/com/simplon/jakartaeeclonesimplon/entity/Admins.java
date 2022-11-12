package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

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

        if (adminId != admins.adminId) return false;
        if (username != null ? !username.equals(admins.username) : admins.username != null) return false;
        if (psswd != null ? !psswd.equals(admins.psswd) : admins.psswd != null) return false;
        if (email != null ? !email.equals(admins.email) : admins.email != null) return false;
        if (adminImage != null ? !adminImage.equals(admins.adminImage) : admins.adminImage != null) return false;
        if (createdOn != null ? !createdOn.equals(admins.createdOn) : admins.createdOn != null) return false;
        if (lastLogin != null ? !lastLogin.equals(admins.lastLogin) : admins.lastLogin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (psswd != null ? psswd.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (adminImage != null ? adminImage.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", psswd='" + psswd + '\'' +
                ", email='" + email + '\'' +
                ", adminImage='" + adminImage + '\'' +
                ", createdOn=" + createdOn +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
