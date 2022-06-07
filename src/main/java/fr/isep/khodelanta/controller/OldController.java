package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.PersonType;
import fr.isep.khodelanta.entities.Annonce;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
public class OldController {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private AnnonceRepository annonceDao;

    @RequestMapping(value = "/old/home")
    public String oldHome(
            Model model,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        if(userDao.findById(Long.valueOf(userId)).get().getPersonType() != PersonType.OLD){return "redirect:/";}
        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        LocalDate localdate = LocalDate.now();
        Date date = Date.valueOf(localdate);

        model.addAttribute("annoncesByOwner", annonceDao.findAnnoncesByOwner(user));
        model.addAttribute("annoncesByOwnerAndDate", annonceDao.findAnnonceByDateAndOwner(date, user));
        model.addAttribute("user", user);

        // System.out.println(annonceDao.findAll());
        // System.out.println("Voici le status "+userDao.findById(Long.valueOf(userId)).get().getPersonType());
        model.addAttribute("annonces", annonceDao.findByIsverified(true));
        return "oldHome";
    }

    @RequestMapping(value="/old/editProfile")
    public String editProfile(
            Model model, HttpServletRequest request, HttpSession session){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        if(userDao.findById(Long.valueOf(userId)).get().getPersonType() != PersonType.OLD){return "redirect:/";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);
        return "editProfile";
    }

    @RequestMapping(value="/old/updateProfile")
    private String updateUser(HttpServletRequest request, Model model, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail) {
        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        if(userDao.findById(Long.valueOf(userId)).get().getPersonType() != PersonType.OLD){return "redirect:/";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);

        user.updateUser(firstname, lastname, mail);

        userDao.save(user);
        return "redirect:/";
    }
}
