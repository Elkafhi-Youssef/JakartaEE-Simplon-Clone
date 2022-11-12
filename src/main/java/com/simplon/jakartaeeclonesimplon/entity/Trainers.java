package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
public class Trainers {
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
    @Column(name = "delete_at")
    private Date deleteAt;
    @OneToMany(mappedBy = "trainersByTrainerId")
    private Collection<Briefs> briefsByTrainerId;
    @OneToMany(mappedBy = "trainersByTrainerId")
    private Collection<Promos> promosByTrainerId;

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

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Timestamp deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainers trainers = (Trainers) o;

        if (trainerId != trainers.trainerId) return false;
        if (username != null ? !username.equals(trainers.username) : trainers.username != null) return false;
        if (psswd != null ? !psswd.equals(trainers.psswd) : trainers.psswd != null) return false;
        if (email != null ? !email.equals(trainers.email) : trainers.email != null) return false;
        if (trainerImage != null ? !trainerImage.equals(trainers.trainerImage) : trainers.trainerImage != null)
            return false;
        if (deleteAt != null ? !deleteAt.equals(trainers.deleteAt) : trainers.deleteAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainerId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (psswd != null ? psswd.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (trainerImage != null ? trainerImage.hashCode() : 0);
        result = 31 * result + (deleteAt != null ? deleteAt.hashCode() : 0);
        return result;
    }

    public Collection<Briefs> getBriefsByTrainerId() {
        return briefsByTrainerId;
    }

    public void setBriefsByTrainerId(Collection<Briefs> briefsByTrainerId) {
        this.briefsByTrainerId = briefsByTrainerId;
    }

    public Collection<Promos> getPromosByTrainerId() {
        return promosByTrainerId;
    }

    public void setPromosByTrainerId(Collection<Promos> promosByTrainerId) {
        this.promosByTrainerId = promosByTrainerId;
    }

    @Override
    public String toString() {
        return "Trainers{" +
                "trainerId=" + trainerId +
                ", username='" + username + '\'' +
                ", psswd='" + psswd + '\'' +
                ", email='" + email + '\'' +
                ", trainerImage='" + trainerImage + '\'' +
                ", deleteAt=" + deleteAt +
                ", briefsByTrainerId=" + briefsByTrainerId +
                ", promosByTrainerId=" + promosByTrainerId +
                '}';
    }
}
