package fr.isep.khodelanta;

import fr.isep.khodelanta.dao.HouseRepository;
import fr.isep.khodelanta.dao.ReservationRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.House;
import fr.isep.khodelanta.entities.Reservation;
import fr.isep.khodelanta.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class KhodeLanta {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(KhodeLanta.class, args);
        UserRepository userDao = ctx.getBean(UserRepository.class);
        HouseRepository houseDao = ctx.getBean(HouseRepository.class);
        ReservationRepository reservationDao = ctx.getBean(ReservationRepository.class);

        //cleaner :
        reservationDao.deleteAll();
        houseDao.deleteAll();
        userDao.deleteAll();



        //seeder :
        User user = new User("admin", "admin", "admin@admin.com", "admin");
        House house = new House(user, "testHouse", "description of house");
        House house2 = new House(user, "testHouse2", "description of house number 2");
        User user2 = new User("user", "user", "user@user.com", "user");
        House houseUser = new House(user2, "testHouseUser", "description of house User");
        House houseUser2 = new House(user2, "testHouseUser2", "description of house User number 2");
        Reservation reservation = new Reservation(houseUser2, user, new Date(), new Date(), false);
        Reservation reservation1 = new Reservation(houseUser, user, new Date(), new Date(), true);

        userDao.save(user);
        houseDao.save(house);
        houseDao.save(house2);
        userDao.save(user2);
        houseDao.save(houseUser);
        houseDao.save(houseUser2);
        reservationDao.save(reservation);
        reservationDao.save(reservation1);

        if(userDao.findByMail("admin@admin.com") == null) {

        }
        if(houseDao.findByTitle("testHouse") == null){

        }
        if(houseDao.findByTitle("testHouse2") == null){

        }

        if(userDao.findByMail("user@user.com") == null) {

        }
        if(houseDao.findByTitle("testHouseUser") == null){

        }
        if(houseDao.findByTitle("testHouseUser2") == null){

        }

        if(reservationDao.findByTenant(user).size() < 2){


        }

    }

}
