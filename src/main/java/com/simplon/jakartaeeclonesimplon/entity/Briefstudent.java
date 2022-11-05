package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(BriefstudentPK.class)
public class Briefstudent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "brief_id")
    private int briefId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private int studentId;
    @ManyToOne
    @JoinColumn(name = "brief_id", referencedColumnName = "brief_id", nullable = false)
    private Briefs briefsByBriefId;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Students studentsByStudentId;

    public int getBriefId() {
        return briefId;
    }

    public void setBriefId(int briefId) {
        this.briefId = briefId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Briefstudent that = (Briefstudent) o;
        return briefId == that.briefId && studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(briefId, studentId);
    }

    public Briefs getBriefsByBriefId() {
        return briefsByBriefId;
    }

    public void setBriefsByBriefId(Briefs briefsByBriefId) {
        this.briefsByBriefId = briefsByBriefId;
    }

    public Students getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(Students studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }
}
