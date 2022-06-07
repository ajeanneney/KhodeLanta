package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Annonce;
import fr.isep.khodelanta.entities.Categorie;
import fr.isep.khodelanta.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    @Query("select u from Annonce u where u.title LIKE :title AND u.city = :city AND u.categories = :categories")
    public Annonce search(
            @Param("title")String titre,
            @Param("city") City city,
            @Param("categories")List<Categorie> categories);

    //filtre en fonction de la distance
    //filtre en fonction du prix
    @Query("select u from Annonce u where u.isverified = :x")
    public List<Annonce> findByIsverified(@Param("x")boolean isverified);

}
