package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

}
