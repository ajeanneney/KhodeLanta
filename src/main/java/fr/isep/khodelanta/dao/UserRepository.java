package fr.isep.khodelanta.dao;

import fr.isep.khodelanta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u where u.mail = :x")
//    public User findByMail(@Param("x")String mail);

    public User findByMail(String mail);

    @Query("select u from User u where u.id = :x")
    public User findUserByUserId(@Param("x") Long id);

}
