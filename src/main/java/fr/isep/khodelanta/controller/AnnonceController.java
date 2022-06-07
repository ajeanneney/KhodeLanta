package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.CategorieRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.Annonce;
import fr.isep.khodelanta.entities.Categorie;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class AnnonceController {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private AnnonceRepository annonceDao;

    @Autowired
    private CategorieRepository categorieDao;

    @RequestMapping(value = "/old/newannonce")
    public String newAnnonce(
        Model model,
        HttpServletRequest request,
        @RequestParam(value = "title", defaultValue = "") String title,
        @RequestParam(value = "description", defaultValue = "") String description,
        @RequestParam(value = "adresse", defaultValue = "") String adresse,
        @RequestParam(value = "categories", required = false) Long[] categories,
        @RequestParam(value = "date", required = false) String date
    ){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";} //si pas connecté retour page connexion

        if(!Objects.equals(title, "") && !Objects.equals(description, "") && !Objects.equals(adresse, "")){
            User user = userDao.getById(Long.valueOf(userId));

            List<Categorie> annonceCategories =
                    Arrays.stream(categories).map(n->{
                        return categorieDao.findById(n).orElse(null);
                    }).collect(Collectors.toList());

            Annonce annonce = new Annonce(user, title, description, adresse, annonceCategories, date);
            annonceDao.save(annonce);
            return "redirect:/";
        }

        model.addAttribute("categories", categorieDao.findAll());
        model.addAttribute("annonces", annonceDao.findAll());


        return "newannonce";
    }

}
