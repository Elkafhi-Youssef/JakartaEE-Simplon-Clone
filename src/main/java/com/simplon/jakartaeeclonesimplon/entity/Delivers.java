package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Delivers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "deliver_id")
    private int deliverId;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "repo_link")
    private String repoLink;
    @Basic
    @Column(name = "student_id")
    private Integer studentId;
    @Basic
    @Column(name = "brief_id")
    private Integer briefId;
    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable =false)
    private Students studentsByStudentId;
    @ManyToOne
    @JoinColumn(name = "brief_id", referencedColumnName = "brief_id", insertable = false, updatable =false)
    private Briefs briefsByBriefId;

    public int getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(int deliverId) {
        this.deliverId = deliverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRepoLink() {
        return repoLink;
    }

    public void setRepoLink(String repoLink) {
        this.repoLink = repoLink;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBriefId() {
        return briefId;
    }

    public void setBriefId(Integer briefId) {
        this.briefId = briefId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivers delivers = (Delivers) o;

        if (deliverId != delivers.deliverId) return false;
        if (message != null ? !message.equals(delivers.message) : delivers.message != null) return false;
        if (repoLink != null ? !repoLink.equals(delivers.repoLink) : delivers.repoLink != null) return false;
        if (studentId != null ? !studentId.equals(delivers.studentId) : delivers.studentId != null) return false;
        if (briefId != null ? !briefId.equals(delivers.briefId) : delivers.briefId != null) return false;
        if (createdOn != null ? !createdOn.equals(delivers.createdOn) : delivers.createdOn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliverId;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (repoLink != null ? repoLink.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (briefId != null ? briefId.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        return result;
    }

    public Students getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(Students studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    public Briefs getBriefsByBriefId() {
        return briefsByBriefId;
    }

    public void setBriefsByBriefId(Briefs briefsByBriefId) {
        this.briefsByBriefId = briefsByBriefId;
    }
}
