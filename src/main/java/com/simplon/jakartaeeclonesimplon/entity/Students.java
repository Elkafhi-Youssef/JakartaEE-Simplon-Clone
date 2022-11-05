package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private int studentId;
    @Basic
    @Column(name = "psswd")
    private String psswd;
    @Basic
    @Column(name = "email")
    private String email;
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
    @Column(name = "delete_at")
    private Timestamp deleteAt;
    @Basic
    @Column(name = "promo_id")
    private Integer promoId;
//    @OneToMany(mappedBy = "studentsByStudentId")
//    private Collection<Briefstudent> briefstudentsByStudentId;
@ManyToMany(cascade = { CascadeType.ALL })
@JoinTable(
        name = "Briefstudent",
        joinColumns = { @JoinColumn(name = "student_id") },
        inverseJoinColumns = { @JoinColumn(name = "brief_id") }
)
Set<Briefs> briefs = new HashSet<Briefs>();

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public Timestamp getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Timestamp deleteAt) {
        this.deleteAt = deleteAt;
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
        Students students = (Students) o;
        return studentId == students.studentId && Objects.equals(psswd, students.psswd) && Objects.equals(email, students.email) && Objects.equals(promoName, students.promoName) && Objects.equals(studentImage, students.studentImage) && Objects.equals(createdOn, students.createdOn) && Objects.equals(deleteAt, students.deleteAt) && Objects.equals(promoId, students.promoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, psswd, email, promoName, studentImage, createdOn, deleteAt, promoId);
    }

    public Collection<Briefstudent> getBriefstudentsByStudentId() {
        return briefstudentsByStudentId;
    }

    public void setBriefstudentsByStudentId(Collection<Briefstudent> briefstudentsByStudentId) {
        this.briefstudentsByStudentId = briefstudentsByStudentId;
    }
}
