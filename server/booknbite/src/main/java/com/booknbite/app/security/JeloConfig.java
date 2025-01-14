package com.booknbite.app.security;

import com.booknbite.app.model.CjenovniRang;
import com.booknbite.app.model.Jelo;
import com.booknbite.app.model.JeloRestoran;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.repository.JeloRepository;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JeloConfig {

    private final JeloRepository jeloRepository;
    private final RestoranRepository restoranRepository;
    private final JeloRestoranRepository jeloRestoranRepository;

    @Autowired
    public JeloConfig(JeloRepository jeloRepository, RestoranRepository restoranRepository, JeloRestoranRepository jeloRestoranRepository){
        this.jeloRepository = jeloRepository;
        this.restoranRepository = restoranRepository;
        this.jeloRestoranRepository = jeloRestoranRepository;
    }

    @Bean
    public CommandLineRunner initializeProducts() {
        return args -> {

            Restoran [] restorani = {
                    new Restoran("najjaciRestoran", "tkalciceva 1", "12:00", "20:00", CjenovniRang.JEFTINO, "5432632", "opasna slika", "korisnik1", "ivan", "ivic", false, true,"120301143444852683622", "najjaci@fer.hr", "najjaci"),
                    new Restoran("kfc", "arena 5", "12:00", "20:00", CjenovniRang.SKUPO, "6354636", "opasna slika", "korisnik2", "milan", "milic", false, true,"120301143444252483622", "kfc@fer.hr", "kfc"),
                    new Restoran("mc donalds", "jelacicev trg 4", "12:00", "20:00", CjenovniRang.SREDNJE, "5248776559", "opasna slika", "korisnik3", "bobo", "bobic", true, true,"120301143444852533622", "mcdonalds@fer.hr", "mcdonalds"),
                    new Restoran("batak grill", "radnicka 12", "12:00", "20:00", CjenovniRang.SREDNJE, "5242345879", "opasna slika", "korisnik4", "roko", "rokic", true, true,"120301142454852683622", "batak@fer.hr", "batak"),
            };

            for (Restoran restoran : restorani) {
                if (restoranRepository.findById(restoran.getKorisnikId()).isEmpty()) {
                    restoranRepository.save(restoran);
                    System.out.println("Added product: " + restoran.getNazivRestoran());
                }else{
                    System.out.println("Restaurant " + restoran.getNazivRestoran() + " is already added.");
                }
            }

            JeloRestoran [] jelaRestorani = {

            };

            // Define the list of products
            Jelo[] products = {
                    new Jelo(1L, "pizzaImage", "Margherita", "Klasična pizza s rajčicom i sirom.", "50 kn", "Gluten, mlijeko", 0, "obicni"),
                    new Jelo(2L, "steakImage", "Biftek", "Sočni biftek na žaru.", "120 kn", "Nema alergena", 0, "obicni"),
                    new Jelo(3L, "saladImage", "Cezar salata", "Hrskava salata s piletinom i dresingom.", "45 kn", "Jaja, mlijeko", 0, "obicni"),
                    new Jelo(4L, "pastaImage", "Carbonara", "Tjestenina s pancetom i kremastim umakom.", "70 kn", "Gluten, mlijeko, jaja", 0, "obicni")
            };

            // Persist each product in the database
            for (Jelo product : products) {
                if (jeloRepository.findById(product.getJeloId()).isEmpty()) {
                    jeloRepository.save(product);
                    System.out.println("Added product: " + product.getNazivJela());
                } else {
                    System.out.println("Product already exists: " + product.getNazivJela());
                }
            }
        };
    }
}
