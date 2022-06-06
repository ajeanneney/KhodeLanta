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
import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Controller
public class ConnectedController {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private AnnonceRepository annonceDao;

    @Autowired
    private CategorieRepository categorieDao;

    @RequestMapping(value = "/oldHome")
    public String oldHome(
            Model model,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");

        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("annonces", annonceDao.findAll());
        System.out.println("Voici le status "+userDao.findById(Long.valueOf(userId)).get().getStatus());
        return "oldHome";
    }
    @RequestMapping(value = "/studentHome")
    public String studentHome(
            Model model,
            HttpServletRequest request){
        model.addAttribute("annonces", annonceDao.findAll());

        return "studentHome";
    }
    @RequestMapping(value = "/adminHome")
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
