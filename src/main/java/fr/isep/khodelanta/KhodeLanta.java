package fr.isep.khodelanta;

import fr.isep.khodelanta.dao.CategorieRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.Annonce;
import fr.isep.khodelanta.entities.Categorie;
import fr.isep.khodelanta.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class KhodeLanta {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(KhodeLanta.class, args);
        UserRepository userDao = ctx.getBean(UserRepository.class);
        CategorieRepository categorieDao = ctx.getBean(CategorieRepository.class);


        //seeder :
        if(userDao.findAll().size() == 0) {
            User user = new User("admin", "admin", "admin@admin.com", "admin", "3");
            User user2 = new User("user", "user", "user@user.com", "user", "2");
            userDao.save(user);
            userDao.save(user2);
        }

        if(categorieDao.findAll().size() == 0){
            categorieDao.save(new Categorie("Jardinier", "Faire du jardinage"));
            categorieDao.save(new Categorie("Cuisine", "Faire la cuisine"));
        }


    }

}
