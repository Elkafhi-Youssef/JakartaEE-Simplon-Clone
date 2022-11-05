package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Briefs {
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
    @Column(name = "image")
    private String image;
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
    private Collection<Briefstudent> briefstudentsByBriefId;

    @ManyToMany(mappedBy = "students")
    private Set<Students> employees = new HashSet<>();

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        Briefs briefs = (Briefs) o;
        return briefId == briefs.briefId && trainerId == briefs.trainerId && Objects.equals(briefTitle, briefs.briefTitle) && Objects.equals(description, briefs.description) && Objects.equals(image, briefs.image) && Objects.equals(dateStarted, briefs.dateStarted) && Objects.equals(dateEnd, briefs.dateEnd) && Objects.equals(technologies, briefs.technologies) && Objects.equals(repository, briefs.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(briefId, briefTitle, description, image, dateStarted, dateEnd, technologies, repository, trainerId);
    }

    public Collection<Briefstudent> getBriefstudentsByBriefId() {
        return briefstudentsByBriefId;
    }

    public void setBriefstudentsByBriefId(Collection<Briefstudent> briefstudentsByBriefId) {
        this.briefstudentsByBriefId = briefstudentsByBriefId;
    }
}
