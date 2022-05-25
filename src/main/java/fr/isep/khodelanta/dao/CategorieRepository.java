package fr.isep.khodelanta.dao;


import fr.isep.khodelanta.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
