package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class ConnectedController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private HouseRepository houseDao;

    @RequestMapping(value = "/home")
    public String home(
            Model model,
            @CookieValue(value = "userId", defaultValue = "") String userId){
        if(Objects.equals(userId, "")){return "redirect:connexion";} //si pas connecté retour page connexion
        else{
            User user = userDao.findById(Long.valueOf(userId)).orElse(null);
            model.addAttribute("user", user);

            List<House> houses = houseDao.findByOwner(user);
            model.addAttribute("houses", houses);

            return "home";
        }
    }
}
