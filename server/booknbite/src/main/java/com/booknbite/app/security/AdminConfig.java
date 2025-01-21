package com.booknbite.app.security;

import com.booknbite.app.model.Administrator;
import com.booknbite.app.model.UserType;
import com.booknbite.app.model.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdminConfig(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Bean
    public Administrator administratorBean() {

        String adminId = "107896405271530820151";
        String email = "test.booknbite@gmail.com";
        String korisnickoIme = "Test";



//        String reneId = "110301143444852683612";
//        String reneEmail = "rene.filipovic03@gmail.com";
//        String reneKorIme = "rene filipovic";

//        Administrator reneAdmin = new Administrator();
//        reneAdmin.setKorisnikId(reneId);
//        reneAdmin.setEmail(reneEmail);
//        reneAdmin.setKorisnickoIme(reneKorIme);
//        reneAdmin.setUserType(UserType.ADMINISTRATOR);
//
//        return reneAdmin;

        // Create Administrator instance
        Administrator admin = new Administrator();
        admin.setKorisnikId(adminId);
        admin.setEmail(email);
        admin.setKorisnickoIme(korisnickoIme);
        admin.setUserType(UserType.ADMINISTRATOR);

        return admin;


    }

    @Bean
    public CommandLineRunner initializeAdmin(Administrator administratorBean) {
        return args -> {
            if (administratorRepository.findById(administratorBean.getKorisnikId()).isEmpty()) {
                // Save Administrator to the database if it does not exist
                administratorRepository.save(administratorBean);
                System.out.println("Administrator created in the database at startup!");
            } else {
                System.out.println("Administrator already exists in the database.");
            }
        };
    }
}
