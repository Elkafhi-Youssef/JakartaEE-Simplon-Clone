package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Promos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "promo_id")
    private int promoId;
    @Basic
    @Column(name = "promo_name")
    private String promoName;
    @Basic
    @Column(name = "created_on")
    private String createdOn;
    @Basic
    @Column(name = "trainer_id")
    private Integer trainerId;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<Briefs> briefsByPromoId;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id", insertable = false, updatable =false)
    private Trainers trainersByTrainerId;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<Students> studentsByPromoId;

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promos promos = (Promos) o;

        if (promoId != promos.promoId) return false;
        if (promoName != null ? !promoName.equals(promos.promoName) : promos.promoName != null) return false;
        if (createdOn != null ? !createdOn.equals(promos.createdOn) : promos.createdOn != null) return false;
        if (trainerId != null ? !trainerId.equals(promos.trainerId) : promos.trainerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = promoId;
        result = 31 * result + (promoName != null ? promoName.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (trainerId != null ? trainerId.hashCode() : 0);
        return result;
    }

    public Collection<Briefs> getBriefsByPromoId() {
        return briefsByPromoId;
    }

    public void setBriefsByPromoId(Collection<Briefs> briefsByPromoId) {
        this.briefsByPromoId = briefsByPromoId;
    }

    public Trainers getTrainersByTrainerId() {
        return trainersByTrainerId;
    }

    public void setTrainersByTrainerId(Trainers trainersByTrainerId) {
        this.trainersByTrainerId = trainersByTrainerId;
    }

    public Collection<Students> getStudentsByPromoId() {
        return studentsByPromoId;
    }

    public void setStudentsByPromoId(Collection<Students> studentsByPromoId) {
        this.studentsByPromoId = studentsByPromoId;
    } @Override
    public String toString() {
        return "Promos{" +
                "promoId=" + promoId +
                ", promoName='" + promoName + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", trainerId=" + trainerId +
                ", briefsByPromoId=" + briefsByPromoId +
                ", trainersByTrainerId=" + trainersByTrainerId +
                ", studentsByPromoId=" + studentsByPromoId +
                '}';
    }
}
