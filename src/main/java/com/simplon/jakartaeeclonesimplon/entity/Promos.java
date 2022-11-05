package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

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
    private Date createdOn;
    @Basic
    @Column(name = "trainer_id")
    private Integer trainerId;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
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
        return promoId == promos.promoId && Objects.equals(promoName, promos.promoName) && Objects.equals(createdOn, promos.createdOn) && Objects.equals(trainerId, promos.trainerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promoId, promoName, createdOn, trainerId);
    }

    public Collection<Students> getStudentsByPromoId() {
        return studentsByPromoId;
    }

    public void setStudentsByPromoId(Collection<Students> studentsByPromoId) {
        this.studentsByPromoId = studentsByPromoId;
    }
}
