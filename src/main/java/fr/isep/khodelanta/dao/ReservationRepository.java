package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.Reservation;
import fr.isep.khodelanta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r where r.tenantUser = :x")
    public List<Reservation> findByTenant(@Param("x")User tenant);

}
