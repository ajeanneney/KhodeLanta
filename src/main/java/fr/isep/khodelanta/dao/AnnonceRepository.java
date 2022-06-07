package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    //filtre en fonction de la distance
    //filtre en fonction du prix
    @Query("select u from Annonce u where u.isverified = :x")
    public List<Annonce> findByIsverified(@Param("x")boolean isverified);

}
