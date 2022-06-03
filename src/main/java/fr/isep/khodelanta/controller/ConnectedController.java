package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
public class ConnectedController {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private AnnonceRepository annonceDao;

    @RequestMapping(value = "/home")
    public String home(
            Model model,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        System.out.println(userId);
        System.out.println(userDao.findById(Long.valueOf(userId)).get().getFirstname());

        if(userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);

        model.addAttribute("annonces", annonceDao.findAll());
        if(userDao.findById(Long.valueOf(userId)).get().getStatus()=="3"){
            return "redirect:/studentPage";
        }
        return "home";
    }
    @RequestMapping(value = "/studentPage")
    public String studentPage(
            Model model,
            HttpServletRequest request){
        return "studentPage";
    }
}
