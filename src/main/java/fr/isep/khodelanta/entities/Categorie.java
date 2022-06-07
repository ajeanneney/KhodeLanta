package fr.isep.khodelanta.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToMany
    private List<Annonce> annonces;

    @ManyToMany
    private List<Recherche> recherches;

    public Categorie() {
    }

    public Categorie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public List<Recherche> getRecherches() {
        return recherches;
    }

    public void setRecherches(List<Recherche> recherches) {
        this.recherches = recherches;
    }
}
