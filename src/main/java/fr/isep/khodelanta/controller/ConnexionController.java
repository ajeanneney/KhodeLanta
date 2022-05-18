package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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
            HttpServletResponse response){

        if(!Objects.equals(mail, "") && !Objects.equals(password, "")) {
            User user = userDao.findByMail(mail);
            if(Objects.equals(user.getPassword(), password)){
                Cookie cookie = new Cookie("userId", user.getId().toString());
                response.addCookie(cookie);
                return "redirect:home";
            } else{
                System.out.println("mauvais password");
            }
        }
        return "connexion";
    }

    @RequestMapping(value = "/connected")
    public String connected(){
        return "connected";
    }

    @RequestMapping(value = "/signup")
    public String signUp(
            ServletRequest request,
            HttpServletResponse response){

        Map<String, String[]> paramMap = request.getParameterMap();

        if(paramMap.containsKey("firstname") && paramMap.containsKey("lastname") && paramMap.containsKey("mail") && paramMap.containsKey("password")){
            System.out.println(Arrays.toString(paramMap.get("firstname")));
            User user = new User(
                    paramMap.get("firstname")[0],
                    paramMap.get("lastname")[0],
                    paramMap.get("mail")[0],
                    paramMap.get("password")[0]
            );
            if(userDao.findByMail(user.getMail()) == null) {
                Long newUserId = userDao.saveAndFlush(user).getId();
                Cookie cookie = new Cookie("userId", newUserId.toString());
                response.addCookie(cookie);
                System.out.println("new user");
                return "redirect:home";
            } else{
                System.out.println("mail deja utilisé");
                return "signup";
            }
        }
        return "signup";
    }

}
