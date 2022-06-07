package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Recherche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RechercheRepository extends JpaRepository<Recherche, Long> {
}
