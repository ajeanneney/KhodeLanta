package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.House;
import fr.isep.khodelanta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("select h from House h where h.title = :x")
    public House findByTitle(@Param("x")String title);

    @Query("select h from House h where h.owner = :x")
    public List<House> findByOwner(@Param("x")User owner);
}
