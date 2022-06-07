package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Annonce;
import fr.isep.khodelanta.entities.Categorie;
import fr.isep.khodelanta.entities.City;
import fr.isep.khodelanta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.persistence.TypedQuery;
import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    public List<Annonce> findAnnoncesByOwner(User user);

    public List<Annonce> findAnnoncesByDate(Date date);

    public List<Annonce> findAnnonceByDateAndOwner(Date date, User user);

    @Query("select u from Annonce u where u.isverified = :x")
    public List<Annonce> findByIsverified(@Param("x")boolean isverified);

}
