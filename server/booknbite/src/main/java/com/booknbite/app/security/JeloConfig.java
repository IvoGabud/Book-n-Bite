package com.booknbite.app.security;

import com.booknbite.app.model.CjenovniRang;
import com.booknbite.app.model.JeloRestoran;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JeloConfig {

    private final RestoranRepository restoranRepository;
    private final JeloRestoranRepository jeloRestoranRepository;

    @Autowired
    public JeloConfig(RestoranRepository restoranRepository, JeloRestoranRepository jeloRestoranRepository){
        this.restoranRepository = restoranRepository;
        this.jeloRestoranRepository = jeloRestoranRepository;
    }

    @Bean
    public CommandLineRunner initializeProducts() {
        return args -> {

            Restoran [] restorani = {
                    new Restoran("najjaciRestoran", "tkalciceva 1", "12:00", "20:00", CjenovniRang.JEFTINO, "5432632", "opasna slika", "korisnik1", "ivan", "ivic", false, true,"120301143444852683622", "najjaci@fer.hr", "najjaci"),
                    new Restoran("kfc", "arena 5", "12:00", "20:00", CjenovniRang.SKUPO, "6354636", "opasna slika", "korisnik2", "milan", "milic", false, true,"120301143444252483622", "kfc@fer.hr", "kfc"),
                    new Restoran("mc donalds", "jelacicev trg 4", "12:00", "20:00", CjenovniRang.SREDNJE, "5248776559", "opasna slika", "korisnik3", "bobo", "bobic", true, true,"113230222376242142366", "kfc@gmail.com", "kfc"),
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

            JeloRestoran [] jelaRestorani1 = {
                new JeloRestoran(1L, restorani[2], "biftek", "fino meso mmm", "obicni", "20$", "nema", "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/biftek-s-povrcem.jpeg"),
                    new JeloRestoran(2L, restorani[2], "janjetina", "fino meso mmm", "obicni", "10$", "nema", "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/janjetina.jpeg?t=2025-01-15T03%3A48%3A41.869Z"),
                    new JeloRestoran(3L, restorani[2], "svinjetina", "fino meso mmm", "obicni", "10$", "nema", "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/svinjetina.jpg")
            };

            for (JeloRestoran jeloRestoran : jelaRestorani1) {
                if (jeloRestoranRepository.findById(jeloRestoran.getJeloRestoranId()).isEmpty()) {
                    jeloRestoranRepository.save(jeloRestoran);
                    System.out.println("Added product: " + jeloRestoran.getNaziv());
                }else{
                    System.out.println("Jelo " + jeloRestoran.getNaziv() + " is already added.");
                }
            }

            JeloRestoran [] jelaRestorani2 = {
                    new JeloRestoran(4L, restorani[3], "vege burger", "fina travica", "obicni", "20$", "nema", "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/vege-burger.jpg?t=2025-01-15T03%3A51%3A27.340Z"),
                    new JeloRestoran(5L, restorani[3], "burger", "fini mesni burger", "obicni", "10$", "nema", "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/burger.jpg?t=2025-01-15T03%3A53%3A49.102Z"),
                    new JeloRestoran(6L, restorani[3], "cheeseburger", "fino meso i sir", "obicni", "15$", "nema", "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cheeseburger.jpg?t=2025-01-15T03%3A48%3A22.499Z")
            };

            for (JeloRestoran jeloRestoran : jelaRestorani2) {
                if (jeloRestoranRepository.findById(jeloRestoran.getJeloRestoranId()).isEmpty()) {
                    jeloRestoranRepository.save(jeloRestoran);
                    System.out.println("Added product: " + jeloRestoran.getNaziv());
                }else{
                    System.out.println("Jelo " + jeloRestoran.getNaziv() + " is already added.");
                }
            }
        };
    }
}
