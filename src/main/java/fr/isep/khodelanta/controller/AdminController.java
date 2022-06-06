package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.CategorieRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    private CategorieRepository categorieDao;

    @Autowired
    private AnnonceRepository annonceDao;

    @RequestMapping(value = "/admin/home")
    public String adminHome(
            Model model,
            HttpServletRequest request,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "description", required = false) String description){


        if(name != null && !name.isEmpty() && description != null && !description.isEmpty()){
            Categorie categorie = new Categorie(name, description);
            categorieDao.save(categorie);
        }

        model.addAttribute("annonces", annonceDao.findAll());
        return "adminHome";
    }
}
