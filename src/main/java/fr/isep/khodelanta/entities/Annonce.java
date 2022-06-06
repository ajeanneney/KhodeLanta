package fr.isep.khodelanta.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Annonce {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ownerId")
    private User owner;

    private String title;

    private String description;

    private String adresse;

    @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date;

    @ManyToMany
    private List<Categorie> categories;

    public Annonce() {
    }

    public Annonce(User owner, String title, String description, String adresse) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.adresse = adresse;
    }

    public Annonce(User owner, String title, String description, String adresse, List<Categorie> categories) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.adresse = adresse;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }
}
