package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Annonce;
import fr.isep.khodelanta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    //filtre en fonction de la distance
    //filtre en fonction du prix

    public List<Annonce> findAnnoncesByOwner(User user);

    public List<Annonce> findAnnoncesByDate(Date date);

    public List<Annonce> findAnnonceByDateAndOwner(Date date, User user);
}
