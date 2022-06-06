package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @Autowired
    private AnnonceRepository annonceDao;

    @RequestMapping(value = "/student/home")
    public String studentHome(
            Model model,
            HttpServletRequest request){
        model.addAttribute("annonces", annonceDao.findAll());

        return "studentHome";
    }
}
