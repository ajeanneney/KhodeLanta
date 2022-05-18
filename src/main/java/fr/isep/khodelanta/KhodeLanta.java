package fr.isep.khodelanta;

import fr.isep.khodelanta.dao.UserRepository;
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

        //cleaner :
        userDao.deleteAll();



        //seeder :
        User user = new User("admin", "admin", "admin@admin.com", "admin");
        User user2 = new User("user", "user", "user@user.com", "user");

        userDao.save(user);
        userDao.save(user2);


    }

}
