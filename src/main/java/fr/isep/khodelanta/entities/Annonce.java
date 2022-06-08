package fr.isep.khodelanta.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
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

    private City city;

    private String adresse;

    private String prix;

    @Column(columnDefinition = "boolean default false")
    private Boolean isverified;

    @ManyToMany
    private List<Categorie> categories;

    public Annonce() {
    }


    public Annonce(User owner, String title, String description, String adresse, City city, String prix, List<Categorie> categories,Boolean isverified) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.city = city;
        this.prix = prix; 
        this.categories = categories;
        this.adresse = adresse;
        this.isverified = isverified;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public boolean getIsverified() {return isverified;}

    public void setIsverified(Boolean isverified) { this.isverified = isverified;}

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
