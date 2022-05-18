package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.HouseRepository;
import fr.isep.khodelanta.dao.ReservationRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.House;
import fr.isep.khodelanta.entities.Reservation;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class ConnectedController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private HouseRepository houseDao;

    @Autowired
    private ReservationRepository reservationDao;

    @RequestMapping(value = "/home")
    public String home(
            Model model,
            @CookieValue(value = "userId", defaultValue = "") String userId){
        if(Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:connexion";} //si pas connecté retour page connexion
        else{
            User user = userDao.findById(Long.valueOf(userId)).orElse(null);
            model.addAttribute("user", user);

            List<House> houses = houseDao.findByOwner(user);
            model.addAttribute("houses", houses);

            List<Reservation> reservations = reservationDao.findByTenant(user);
            model.addAttribute("reservations", reservations);


            return "home";
        }
    }
}
