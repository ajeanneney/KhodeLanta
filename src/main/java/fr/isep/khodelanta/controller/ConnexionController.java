package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.PersonType;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;

@Controller
public class ConnexionController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/connexion")
    public String connexion(
            @RequestParam(name = "mail", defaultValue = "") String mail,
            @RequestParam(name = "password", defaultValue = "") String password,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId != null && userDao.findById(Long.valueOf(userId)).isPresent()){return "redirect:old/home";}

        if(!Objects.equals(mail, "") && !Objects.equals(password, "")) {
            User user = userDao.findByMail(mail);
            if(Objects.equals(user.getPassword(), encoder(password))){
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId().toString());
                if(user.getPersonType() == PersonType.ADMIN){return "redirect:admin/home";}
                if(user.getPersonType() == PersonType.STUDENT){return "redirect:student/home";}
                if(user.getPersonType() == PersonType.OLD){return "redirect:old/home";}
                return "redirect:/connexion"; //n'est pas censé arriver
            } else{
                System.out.println("mauvais password");
            }
        }
        return "connexion";
    }

    @RequestMapping(value = "/signup")
    public String signUp(
            ServletRequest formRequest,
            HttpServletResponse response,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId != null && userDao.findById(Long.valueOf(userId)).isPresent()){return "redirect:student/home";}
        if(userId != null && userDao.findById(Long.valueOf(userId)).isPresent() && request.getSession().getAttribute("status")=="3"){return "redirect:student/home";}

        Map<String, String[]> paramMap = formRequest.getParameterMap();

        if(paramMap.containsKey("firstname") && paramMap.containsKey("lastname") && paramMap.containsKey("mail") && paramMap.containsKey("password")){
            System.out.println(Arrays.toString(paramMap.get("firstname")));
            User user = new User(
                    paramMap.get("firstname")[0],
                    paramMap.get("lastname")[0],
                    paramMap.get("mail")[0],
                    encoder(paramMap.get("password")[0]),
                    PersonType.valueOf(paramMap.get("persontype")[0])
            );
            if(userDao.findByMail(user.getMail()) == null) {
                Long newUserId = userDao.saveAndFlush(user).getId();
                request.getSession().setAttribute("userId", newUserId.toString());
                if(user.getPersonType() == PersonType.ADMIN){return "redirect:admin/home";}
                if(user.getPersonType() == PersonType.STUDENT){return "redirect:student/home";}
                if(user.getPersonType() == PersonType.OLD){return "redirect:old/home";}
            } else{
                return "signup";
            }
        }
        return "signup";
    }

    public String encoder(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }

}
