package com.simplon.jakartaeeclonesimplon.dao.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private int studentId;
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
    @Column(name = "student_image")
    private String studentImage;

    @Basic
    @Column(name = "delete_at")
    private Date deleteAt;
    @Basic
    @Column(name = "promo_id")
    private Integer promoId;
    @OneToMany(mappedBy = "studentsByStudentId")
    private Collection<Delivers> deliversByStudentId;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "promo_id", referencedColumnName = "promo_id", insertable = false, updatable =false)
    private Promos promosByPromoId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public Date getDeleteAt() {
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
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", username='" + username + '\'' +
                ", psswd='" + psswd + '\'' +
                ", email='" + email + '\'' +
                ", studentImage='" + studentImage + '\'' +
                ", deleteAt=" + deleteAt +
                ", promoId=" + promoId +
                ", deliversByStudentId=" + deliversByStudentId +
                ", promosByPromoId=" + promosByPromoId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (studentId != students.studentId) return false;
        if (username != null ? !username.equals(students.username) : students.username != null) return false;
        if (psswd != null ? !psswd.equals(students.psswd) : students.psswd != null) return false;
        if (email != null ? !email.equals(students.email) : students.email != null) return false;
        if (studentImage != null ? !studentImage.equals(students.studentImage) : students.studentImage != null)
            return false;
        if (deleteAt != null ? !deleteAt.equals(students.deleteAt) : students.deleteAt != null) return false;
        if (promoId != null ? !promoId.equals(students.promoId) : students.promoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (psswd != null ? psswd.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (studentImage != null ? studentImage.hashCode() : 0);
        result = 31 * result + (deleteAt != null ? deleteAt.hashCode() : 0);
        result = 31 * result + (promoId != null ? promoId.hashCode() : 0);
        return result;
    }

    public Collection<Delivers> getDeliversByStudentId() {
        return deliversByStudentId;
    }

    public void setDeliversByStudentId(Collection<Delivers> deliversByStudentId) {
        this.deliversByStudentId = deliversByStudentId;
    }

    public Promos getPromosByPromoId() {
        return promosByPromoId;
    }

    public void setPromosByPromoId(Promos promosByPromoId) {
        this.promosByPromoId = promosByPromoId;
    }
}
