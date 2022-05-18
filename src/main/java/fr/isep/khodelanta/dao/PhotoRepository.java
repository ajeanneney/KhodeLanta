package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
