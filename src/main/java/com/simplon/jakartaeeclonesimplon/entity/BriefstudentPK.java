package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class BriefstudentPK implements Serializable {
    @Column(name = "brief_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int briefId;
    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

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
        BriefstudentPK that = (BriefstudentPK) o;
        return briefId == that.briefId && studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(briefId, studentId);
    }
}
