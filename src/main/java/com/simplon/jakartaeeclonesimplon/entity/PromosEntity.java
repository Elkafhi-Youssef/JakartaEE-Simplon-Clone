package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "promos", schema = "public", catalog = "jeesimplon")
public class PromosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "promo_id")
    private int promoId;
    @Basic
    @Column(name = "promo_name")
    private String promoName;
    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Basic
    @Column(name = "trainer_id")
    private Integer trainerId;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<StudentsEntity> studentsByPromoId;

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

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
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
        PromosEntity that = (PromosEntity) o;
        return promoId == that.promoId && Objects.equals(promoName, that.promoName) && Objects.equals(createdOn, that.createdOn) && Objects.equals(trainerId, that.trainerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promoId, promoName, createdOn, trainerId);
    }

    public Collection<StudentsEntity> getStudentsByPromoId() {
        return studentsByPromoId;
    }

    public void setStudentsByPromoId(Collection<StudentsEntity> studentsByPromoId) {
        this.studentsByPromoId = studentsByPromoId;
    }
}
