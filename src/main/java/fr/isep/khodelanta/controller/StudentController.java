package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.City;
import fr.isep.khodelanta.entities.PersonType;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @Autowired
    private AnnonceRepository annonceDao;

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/student/home")
    public String studentHome(
            Model model,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        if(user.getPersonType() != PersonType.STUDENT){return "redirect:/connexion";}


        model.addAttribute("annonces", annonceDao.findAll());

        return "studentHome";
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

        return "search";
    }

    @RequestMapping(value = "/student/search/result")
    public String searchResult(
            Model model,
            HttpServletRequest request){
        return "searchResult";
    }
}
