package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "public", catalog = "jeesimplon")
public class StudentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private int studentId;
    @Basic
    @Column(name = "promo_name")
    private String promoName;
    @Basic
    @Column(name = "student_image")
    private String studentImage;
    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Basic
    @Column(name = "trainer_id")
    private Integer trainerId;
    @Basic
    @Column(name = "promo_id")
    private Integer promoId;
    @OneToMany(mappedBy = "studentsByStudentId")
    private Collection<BriefStudentEntity> briefStudentsByStudentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
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

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return studentId == that.studentId && Objects.equals(promoName, that.promoName) && Objects.equals(studentImage, that.studentImage) && Objects.equals(createdOn, that.createdOn) && Objects.equals(trainerId, that.trainerId) && Objects.equals(promoId, that.promoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, promoName, studentImage, createdOn, trainerId, promoId);
    }

    public Collection<BriefStudentEntity> getBriefStudentsByStudentId() {
        return briefStudentsByStudentId;
    }

    public void setBriefStudentsByStudentId(Collection<BriefStudentEntity> briefStudentsByStudentId) {
        this.briefStudentsByStudentId = briefStudentsByStudentId;
    }
}
