package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "trainers", schema = "public", catalog = "jeesimplon")
public class TrainersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "trainer_id")
    private int trainerId;
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
    @Column(name = "trainer_image")
    private String trainerImage;
    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Basic
    @Column(name = "last_login")
    private Timestamp lastLogin;
    @OneToMany(mappedBy = "trainersByTrainerId")
    private Collection<BriefsEntity> briefsByTrainerId;
    @OneToOne(mappedBy = "trainersByTrainerId")
    private Collection<PromosEntity> promosByTrainerId;
    @OneToMany(mappedBy = "trainersByTrainerId")
    private Collection<StudentsEntity> studentsByTrainerId;

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
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

    public String getTrainerImage() {
        return trainerImage;
    }

    public void setTrainerImage(String trainerImage) {
        this.trainerImage = trainerImage;
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
        TrainersEntity that = (TrainersEntity) o;
        return trainerId == that.trainerId && Objects.equals(username, that.username) && Objects.equals(psswd, that.psswd) && Objects.equals(email, that.email) && Objects.equals(trainerImage, that.trainerImage) && Objects.equals(createdOn, that.createdOn) && Objects.equals(lastLogin, that.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, username, psswd, email, trainerImage, createdOn, lastLogin);
    }

    public Collection<BriefsEntity> getBriefsByTrainerId() {
        return briefsByTrainerId;
    }

    public void setBriefsByTrainerId(Collection<BriefsEntity> briefsByTrainerId) {
        this.briefsByTrainerId = briefsByTrainerId;
    }

    public Collection<PromosEntity> getPromosByTrainerId() {
        return promosByTrainerId;
    }

    public void setPromosByTrainerId(Collection<PromosEntity> promosByTrainerId) {
        this.promosByTrainerId = promosByTrainerId;
    }

    public Collection<StudentsEntity> getStudentsByTrainerId() {
        return studentsByTrainerId;
    }

    public void setStudentsByTrainerId(Collection<StudentsEntity> studentsByTrainerId) {
        this.studentsByTrainerId = studentsByTrainerId;
    }
}
