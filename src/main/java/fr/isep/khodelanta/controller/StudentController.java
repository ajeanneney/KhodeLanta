package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.CategorieRepository;
import fr.isep.khodelanta.dao.RechercheRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private AnnonceRepository annonceDao;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private CategorieRepository categorieDao;

    @Autowired
    private RechercheRepository rechercheDao;

    @RequestMapping(value = "/student/home")
    public String studentHome(
            Model model,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        if(user.getPersonType() != PersonType.STUDENT){return "redirect:/connexion";}

        model.addAttribute("user", user);
        model.addAttribute("annonces", annonceDao.findAll());

        return "studentHome";
    }


    @RequestMapping(value="/student/editProfile")
    public String editProfile(
            Model model, HttpServletRequest request, HttpSession session){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        if(userDao.findById(Long.valueOf(userId)).get().getPersonType() != PersonType.STUDENT){return "redirect:/";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);
        return "editProfile";
    }

    @RequestMapping(value="/student/updateProfile")
    private String updateUser(HttpServletRequest request, Model model, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail) {
        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        if(userDao.findById(Long.valueOf(userId)).get().getPersonType() != PersonType.STUDENT){return "redirect:/";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);

        user.updateUser(firstname, lastname, mail);

        userDao.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/student/search")
    public String searchForm(
            Model model,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        if(user.getPersonType() != PersonType.STUDENT){return "redirect:/connexion";}

        model.addAttribute("cities", City.values());
        model.addAttribute("categories", categorieDao.findAll());

        return "search";
    }

    @RequestMapping(value = "/student/search/result")
    public String searchResult(
            Model model,
            HttpServletRequest request,
            @RequestParam(value = "title", required = false)String title,
            @RequestParam(value = "city", required = false)String city,
            @RequestParam(value = "date", required = false)String date,
            @RequestParam(value = "categories", required = false) Long[] categories){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        if(user.getPersonType() != PersonType.STUDENT){return "redirect:/connexion";}

        Recherche recherche = new Recherche();
        recherche.setUser(user);
        if(!title.isEmpty()){recherche.setTitle(title);}
        if(!city.isEmpty()){recherche.setCity(City.valueOf(city));}
        if(!date.isEmpty()){recherche.setDate(Date.valueOf(date));}

        System.out.println(Arrays.toString(categories));
        if(categories != null ) {
            List<Categorie> rechercheCategories =
                    Arrays.stream(categories).map(n -> categorieDao.findById(n).orElse(null)).collect(Collectors.toList());
            recherche.setCategories(rechercheCategories);
        }

        rechercheDao.save(recherche);

        return "searchResult";
    }
}
