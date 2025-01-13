package com.booknbite.app.security;

import com.booknbite.app.model.Jelo;
import com.booknbite.app.model.repository.JeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JeloConfig {

    private final JeloRepository jeloRepository;

    @Autowired
    public JeloConfig(JeloRepository jeloRepository){
        this.jeloRepository = jeloRepository;
    }

    @Bean
    public CommandLineRunner initializeProducts() {
        return args -> {
            // Define the list of products
            Jelo[] products = {
                    new Jelo(1L, "pizzaImage", "Margherita", "Klasična pizza s rajčicom i sirom.", "50 kn", "Gluten, mlijeko", 0, "obicna"),
                    new Jelo(2L, "steakImage", "Biftek", "Sočni biftek na žaru.", "120 kn", "Nema alergena", 0, "obicna"),
                    new Jelo(3L, "saladImage", "Cezar salata", "Hrskava salata s piletinom i dresingom.", "45 kn", "Jaja, mlijeko", 0, "obicna"),
                    new Jelo(4L, "pastaImage", "Carbonara", "Tjestenina s pancetom i kremastim umakom.", "70 kn", "Gluten, mlijeko, jaja", 0, "obicna")
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
