package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    //filtre en fonction de la distance
    //filtre en fonction du prix 
}
