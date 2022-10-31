package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "briefs", schema = "public", catalog = "jeesimplon")
public class BriefsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "brief_id")
    private int briefId;
    @Basic
    @Column(name = "brief_title")
    private String briefTitle;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "date_started")
    private Date dateStarted;
    @Basic
    @Column(name = "date_end")
    private Date dateEnd;
    @Basic
    @Column(name = "technologies")
    private Object technologies;
    @Basic
    @Column(name = "repository")
    private Object repository;
    @Basic
    @Column(name = "trainer_id")
    private int trainerId;
    @OneToMany(mappedBy = "briefsByBriefId")
    private Collection<BriefStudentEntity> briefStudentsByBriefId;

    public int getBriefId() {
        return briefId;
    }

    public void setBriefId(int briefId) {
        this.briefId = briefId;
    }

    public String getBriefTitle() {
        return briefTitle;
    }

    public void setBriefTitle(String briefTitle) {
        this.briefTitle = briefTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Object getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Object technologies) {
        this.technologies = technologies;
    }

    public Object getRepository() {
        return repository;
    }

    public void setRepository(Object repository) {
        this.repository = repository;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BriefsEntity that = (BriefsEntity) o;
        return briefId == that.briefId && trainerId == that.trainerId && Objects.equals(briefTitle, that.briefTitle) && Objects.equals(description, that.description) && Objects.equals(dateStarted, that.dateStarted) && Objects.equals(dateEnd, that.dateEnd) && Objects.equals(technologies, that.technologies) && Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(briefId, briefTitle, description, dateStarted, dateEnd, technologies, repository, trainerId);
    }

    public Collection<BriefStudentEntity> getBriefStudentsByBriefId() {
        return briefStudentsByBriefId;
    }

    public void setBriefStudentsByBriefId(Collection<BriefStudentEntity> briefStudentsByBriefId) {
        this.briefStudentsByBriefId = briefStudentsByBriefId;
    }
}
