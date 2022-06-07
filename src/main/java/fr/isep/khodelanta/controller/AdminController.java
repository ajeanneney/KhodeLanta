package fr.isep.khodelanta.controller;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.CategorieRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.Categorie;
import fr.isep.khodelanta.entities.PersonType;
import fr.isep.khodelanta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private CategorieRepository categorieDao;

    @Autowired
    private AnnonceRepository annonceDao;

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/admin/home")
    public String adminHome(
            Model model,
            HttpServletRequest request,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "description", required = false) String description){


        String userId = getUserId(request);
        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";
        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);

        if(name != null && !name.isEmpty() && description != null && !description.isEmpty()){
            Categorie categorie = new Categorie(name, description);
            categorieDao.save(categorie);
        }

        model.addAttribute("annonces", annonceDao.findAll());
        return "adminHome";
    }

    @RequestMapping(value="/admin/editProfile")
    public String editProfile(
            Model model, HttpServletRequest request, HttpSession session){

        String userId = getUserId(request);
        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);
        return "editProfile";
    }

    @RequestMapping(value="/admin/updateProfile")
    private String updateUser(HttpServletRequest request, Model model, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail) {
        String userId = getUserId(request);
        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";

        createUser(userId, model);
        User user = getUser(userId);
        user.updateUser(firstname, lastname, mail);

        userDao.save(user);
        return "redirect:/";
    }



    @RequestMapping(value="/admin/listUsers")
    private String listUsers(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String userId = getUserId(request);
        String message = (String) session.getAttribute("message");
        String bannirMessage = (String) session.getAttribute("banMessage");
        String debannirMessage = (String) session.getAttribute("debanMessage");
        System.out.println(message);

        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";
        createUser(userId, model);
        model.addAttribute("messageConfirmed", message);
        model.addAttribute("bannirMessage", bannirMessage);
        model.addAttribute("debannirMessage", debannirMessage);
        model.addAttribute("users", userDao.findAll());
        return "listUsers";
    }

    @RequestMapping(value="/admin/user/{userOtherId}/edit")
    public String editUser(HttpServletRequest request, Model model, @PathVariable int userOtherId) {
        String userId = getUserId(request);
        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";
        createUser(userId, model);
        User userEdit = userDao.findUserByUserId(Long.valueOf(userOtherId));
        if(!isAdminLong((userEdit.getId()))) return "redirect:/";
        model.addAttribute("otherUser", userEdit);
        return "editUser";
    }

    @RequestMapping(value="/admin/user/{userOtherId}/update")
    private String updateUserFromList(HttpServletRequest request, Model model, @PathVariable int userOtherId, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail) {
        String userId = getUserId(request);
        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";

        createUser(userId, model);
        User userEdit = userDao.findUserByUserId(Long.valueOf(userOtherId));
        if(!isAdminLong((userEdit.getId()))) return "redirect:/";
        userEdit.updateUser(firstname, lastname, mail);
        HttpSession session = request.getSession();
        removeAttributeFromSession(session);
        String message = "Votre modification a bien été effectué";
        session.setAttribute("message",message);
        userDao.save(userEdit);
        return "redirect:/admin/listUsers";
    }


    @RequestMapping(value="/admin/user/{userOtherId}/ban")
    private String banUser(HttpServletRequest request, Model model, @PathVariable int userOtherId){
        String userId = getUserId(request);
        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";

        createUser(userId, model);
        User userEdit = userDao.findUserByUserId(Long.valueOf(userOtherId));

        if(!isAdminLong((userEdit.getId()))) return "redirect:/";
        userEdit.setStatus(0);
        userDao.save(userEdit);

        HttpSession session = request.getSession();
        removeAttributeFromSession(session);
        String banMessage = "L'utilisateur " + userEdit.getFirstname() + " a été banni";
        session.setAttribute("banMessage", banMessage);
        return "redirect:/admin/listUsers";
    }

    @RequestMapping(value="/admin/user/{userOtherId}/deban")
    private String debanUser(HttpServletRequest request, Model model, @PathVariable int userOtherId){
        String userId = getUserId(request);
        if (isUserConnected(userId)) return "redirect:/connexion";
        if (isAdmin(userId)) return "redirect:/";

        createUser(userId, model);
        User userEdit = userDao.findUserByUserId(Long.valueOf(userOtherId));
        if(!isAdminLong((userEdit.getId()))) return "redirect:/";
        userEdit.setStatus(1);
        userDao.save(userEdit);

        HttpSession session = request.getSession();
        removeAttributeFromSession(session);
        String debanMessage = "L'utilisateur " + userEdit.getFirstname() + " a été débanni";
        session.setAttribute("banMessage", debanMessage);
        return "redirect:/admin/listUsers";
    }

    public Model createUser(String userId,  Model model){
        User user = getUser(userId);
        return model.addAttribute("user", user);
    }

    public User getUser(String userId){
        return userDao.findById(Long.valueOf(userId)).orElse(null);
    }
    private String getUserId(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("userId");
    }

    private boolean isAdmin(String userId) {
        if (userDao.findById(Long.valueOf(userId)).get().getPersonType() != PersonType.ADMIN) {
            return true;
        }
        return false;
    }

    private boolean isAdminLong(Long userId){
        if (userDao.findById(userId).get().getPersonType() != PersonType.ADMIN) {
            return true;
        }
        return false;
    }

    private boolean isUserConnected(String userId) {
        if (userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()) {
            return true;
        }
        return false;
    }
    private void removeAttributeFromSession(HttpSession session) {
        session.removeAttribute("message");
        session.removeAttribute("banMessage");
        session.removeAttribute("debanMessage");
    }
}
