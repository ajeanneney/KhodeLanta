package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.PersonType;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class MainController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/")
    public String accueil(HttpServletRequest request){
        String userId = (String) request.getSession().getAttribute("userId");

        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        if(user.getPersonType() == PersonType.ADMIN){return "redirect:admin/home";}
        if(user.getPersonType() == PersonType.STUDENT){return "redirect:student/home";}
        if(user.getPersonType() == PersonType.OLD){return "redirect:old/home";}

        return "/connexion"; //n'est pas censé arriver
    }

    @RequestMapping(value = "/disconnect")
    public String disconnect(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
}
