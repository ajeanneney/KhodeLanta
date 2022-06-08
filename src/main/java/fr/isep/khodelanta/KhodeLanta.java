package fr.isep.khodelanta;

import fr.isep.khodelanta.dao.AnnonceRepository;
import fr.isep.khodelanta.dao.CategorieRepository;
import fr.isep.khodelanta.dao.UserRepository;
import fr.isep.khodelanta.entities.Annonce;
import fr.isep.khodelanta.entities.Categorie;
import fr.isep.khodelanta.entities.PersonType;
import fr.isep.khodelanta.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Base64;
import java.util.Date;

@SpringBootApplication
public class KhodeLanta {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(KhodeLanta.class, args);
        UserRepository userDao = ctx.getBean(UserRepository.class);
        CategorieRepository categorieDao = ctx.getBean(CategorieRepository.class);
        AnnonceRepository annonceDao = ctx.getBean(AnnonceRepository.class);


        //seeder :
        annonceDao.deleteAll();
        userDao.deleteAll();
        categorieDao.deleteAll();

        User user = new User("admin", "admin", "admin@admin.com", encoder("admin"), PersonType.ADMIN);
        User user2 = new User("student", "user", "student@student.com", encoder("user"), PersonType.STUDENT);
        User user3 = new User("old", "user", "old@old.com", encoder("user"), PersonType.OLD);
        User user4 = new User("Yvette", "Tartempion", "yvette.tartempion@gmail.com", encoder("yvette"), PersonType.OLD);
        userDao.save(user);
        userDao.save(user2);
        userDao.save(user3);
        userDao.save(user4);

        categorieDao.save(new Categorie("Informatique", "Aide informatique"));
        categorieDao.save(new Categorie("Jardinier", "Faire du jardinage"));
        categorieDao.save(new Categorie("Cuisine", "Faire la cuisine"));


    }

    public static String encoder(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }
}
