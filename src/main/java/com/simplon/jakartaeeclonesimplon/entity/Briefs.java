package com.simplon.jakartaeeclonesimplon.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

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
    @Basic
    @Column(name = "promo_id")
    private int promoId;
    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id", nullable = false, insertable = false, updatable =false)
    private Trainers trainersByTrainerId;
    @ManyToOne
    @JoinColumn(name = "promo_id", referencedColumnName = "promo_id", nullable = false , insertable = false, updatable =false)
    private Promos promosByPromoId;
    @OneToMany(mappedBy = "briefsByBriefId")
    private Collection<Delivers> deliversByBriefId;

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

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Briefs briefs = (Briefs) o;

        if (briefId != briefs.briefId) return false;
        if (trainerId != briefs.trainerId) return false;
        if (promoId != briefs.promoId) return false;
        if (briefTitle != null ? !briefTitle.equals(briefs.briefTitle) : briefs.briefTitle != null) return false;
        if (description != null ? !description.equals(briefs.description) : briefs.description != null) return false;
        if (image != null ? !image.equals(briefs.image) : briefs.image != null) return false;
        if (dateStarted != null ? !dateStarted.equals(briefs.dateStarted) : briefs.dateStarted != null) return false;
        if (dateEnd != null ? !dateEnd.equals(briefs.dateEnd) : briefs.dateEnd != null) return false;
        if (technologies != null ? !technologies.equals(briefs.technologies) : briefs.technologies != null)
            return false;
        if (repository != null ? !repository.equals(briefs.repository) : briefs.repository != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = briefId;
        result = 31 * result + (briefTitle != null ? briefTitle.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (dateStarted != null ? dateStarted.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (technologies != null ? technologies.hashCode() : 0);
        result = 31 * result + (repository != null ? repository.hashCode() : 0);
        result = 31 * result + trainerId;
        result = 31 * result + promoId;
        return result;
    }

    public Trainers getTrainersByTrainerId() {
        return trainersByTrainerId;
    }

    public void setTrainersByTrainerId(Trainers trainersByTrainerId) {
        this.trainersByTrainerId = trainersByTrainerId;
    }

    public Promos getPromosByPromoId() {
        return promosByPromoId;
    }

    public void setPromosByPromoId(Promos promosByPromoId) {
        this.promosByPromoId = promosByPromoId;
    }

    public Collection<Delivers> getDeliversByBriefId() {
        return deliversByBriefId;
    }

    public void setDeliversByBriefId(Collection<Delivers> deliversByBriefId) {
        this.deliversByBriefId = deliversByBriefId;
    }
}
