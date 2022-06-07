package fr.isep.khodelanta.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Recherche {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private String title;
    private Date date;
    private City city;

    @ManyToMany
    private List<Categorie> categories;

    public Recherche() {
    }

    public Recherche(String title, Date date, City city, List<Categorie> categories) {
        this.title = title;
        this.date = date;
        this.city = city;
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
