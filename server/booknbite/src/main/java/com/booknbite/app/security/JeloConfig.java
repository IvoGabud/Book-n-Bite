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

import java.util.List;

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

            List<Restoran> restorani = List.of(
                    new Restoran(
                            "Pizzeria Bella",
                            45.3452377, // latitude
                            19.0010204, // longitude
                            "10:00",
                            "23:00",
                            CjenovniRang.SREDNJE,
                            "+38512345678",
                            "https://example.com/images/pizzeria-bella.jpg",
                            "bella_user",
                            "Ivana",
                            "Horvat",
                            true,
                            true,
                            "107891114272534826111",
                            "ivana.horvat@example.com",
                            "pizzeriaBella"
                    ),
                    new Restoran(
                            "Konoba Dalmacija",
                            43.508133, // latitude (Split)
                            16.441736, // longitude (Split)
                            "12:00",
                            "02:00",
                            CjenovniRang.SKUPO,
                            "+38598765432",
                            "https://example.com/images/konoba-dalmacija.jpg",
                            "dalmacija_user",
                            "Ante",
                            "Perić",
                            true,
                            true,
                            "ID002",
                            "ante.peric@example.com",
                            "konobaDalmacija"
                    ),
                    new Restoran(
                            "Bistro Gourmet",
                            45.327222, // latitude (Rijeka)
                            14.441111, // longitude (Rijeka)
                            "08:00",
                            "22:00",
                            CjenovniRang.SKUPO,
                            "+385912345678",
                            "https://example.com/images/bistro-gourmet.jpg",
                            "gourmet_user",
                            "Petra",
                            "Novak",
                            false,
                            true,
                            "ID003",
                            "petra.novak@example.com",
                            "bistroGourmet"
                    ),
                    new Restoran(
                            "Grill House",
                            45.551187, // latitude (Osijek)
                            18.693748, // longitude (Osijek)
                            "09:00",
                            "21:00",
                            CjenovniRang.SREDNJE,
                            "+385923456789",
                            "https://example.com/images/grill-house.jpg",
                            "grill_user",
                            "Marko",
                            "Kovač",
                            false,
                            true,
                            "ID004",
                            "marko.kovac@example.com",
                            "grillHouse"
                    ),
                    new Restoran(
                            "Veggie Haven",
                            44.118718, // latitude (Zadar)
                            15.231363, // longitude (Zadar)
                            "10:00",
                            "20:00",
                            CjenovniRang.JEFTINO,
                            "+385998765432",
                            "https://example.com/images/veggie-haven.jpg",
                            "veggie_user",
                            "Lana",
                            "Matić",
                            false,
                            true,
                            "ID005",
                            "lana.matic@example.com",
                            "veggieHaven"
                    ),
                    new Restoran(
                            "Sweet Treats",
                            42.640431, // latitude (Dubrovnik)
                            18.108081, // longitude (Dubrovnik)
                            "08:00",
                            "18:00",
                            CjenovniRang.SREDNJE,
                            "+385954321234",
                            "https://example.com/images/sweet-treats.jpg",
                            "sweet_user",
                            "Karla",
                            "Šarić",
                            true,
                            true,
                            "ID006",
                            "karla.saric@example.com",
                            "sweetTreats"
                    )
            );

            for (Restoran restoran : restorani) {
                if (restoranRepository.findById(restoran.getKorisnikId()).isEmpty()) {
                    restoranRepository.save(restoran);
                    System.out.println("Added product: " + restoran.getNazivRestoran());
                }else{
                    System.out.println("Restaurant " + restoran.getNazivRestoran() + " is already added.");
                }
            }

            List<JeloRestoran> jelaPizzeriaBella = List.of(
                    new JeloRestoran(
                            1L,
                            restorani.get(0),
                            "Margherita",
                            "Tradicionalna pizza s rajčicom, mozzarellom i bosiljkom.",
                            "obicni",
                            "40 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/margherita.jpg?t=2025-01-15T05%3A07%3A14.582Z"
                    ),
                    new JeloRestoran(
                            2L,
                            restorani.get(0),
                            "Capricciosa",
                            "Pizza s rajčicom, mozzarellom, šunkom, gljivama i maslinama.",
                            "obicni",
                            "50 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/capricciosa.jpg?t=2025-01-15T05%3A07%3A53.325Z"
                    ),
                    new JeloRestoran(
                            3L,
                            restorani.get(0),
                            "Pepperoni",
                            "Začinjena pizza s rajčicom, mozzarellom i pikantnim salaminama.",
                            "obicni",
                            "55 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/pepperoni.jpg?t=2025-01-15T05%3A08%3A03.853Z"
                    ),
                    new JeloRestoran(
                            4L,
                            restorani.get(0),
                            "Vegetariana",
                            "Pizza s raznovrsnim povrćem, rajčicom i mozzarellom.",
                            "obicni",
                            "45 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/vegetariana.jpg?t=2025-01-15T05%3A08%3A14.911Z"
                    ),
                    new JeloRestoran(
                            5L,
                            restorani.get(0),
                            "Quattro Formaggi",
                            "Pizza s mješavinom četiri vrste sira.",
                            "obicni",
                            "60 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/quattro-formaggi.jpeg?t=2025-01-15T05%3A08%3A26.903Z"
                    )
            );

            for (JeloRestoran jeloRestoran : jelaPizzeriaBella) {
                if (jeloRestoranRepository.findById(jeloRestoran.getJeloRestoranId()).isEmpty()) {
                    jeloRestoranRepository.save(jeloRestoran);
                    System.out.println("Added product: " + jeloRestoran.getNaziv());
                }else{
                    System.out.println("Jelo " + jeloRestoran.getNaziv() + " is already added.");
                }
            }

            List<JeloRestoran> jelaKonobaDalmacija = List.of(
                    new JeloRestoran(
                            6L,
                            restorani.get(1),
                            "Pašticada",
                            "Tradicionalno dalmatinsko jelo s govedinom, povrćem i vinom.",
                            "obicni",
                            "80 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/pasticada.jpg?t=2025-01-15T05%3A08%3A37.712Z"
                    ),
                    new JeloRestoran(
                            7L,
                            restorani.get(1),
                            "Grilled Fish",
                            "Svježe pečena riba s limunom i maslinovim uljem.",
                            "obicni",
                            "90 HRK",
                            "Riba, Gluten",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/grilled-fish.jpg?t=2025-01-15T05%3A08%3A59.004Z"
                    ),
                    new JeloRestoran(
                            8L,
                            restorani.get(1),
                            "Black Risotto",
                            "Crni rižoto s lignjama i inkama.",
                            "obicni",
                            "75 HRK",
                            "Gluten, Laktoza, Lignje",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/black-risotto.jpg?t=2025-01-15T05%3A09%3A11.805Z"
                    ),
                    new JeloRestoran(
                            9L,
                            restorani.get(1),
                            "Ćevapi",
                            "Tradicionalni ćevapi s lukom i kajmakom.",
                            "obicni",
                            "50 HRK",
                            "Gluten",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cevapi.jpg?t=2025-01-15T05%3A09%3A25.809Z"
                    ),
                    new JeloRestoran(
                            10L,
                            restorani.get(1),
                            "Soparnik",
                            "Dalmatinski soparnik s blitvom i maslinovim uljem.",
                            "obicni",
                            "40 HRK",
                            "Gluten",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/soparnik.jpeg?t=2025-01-15T05%3A10%3A07.298Z"
                    )
            );

            for (JeloRestoran jeloRestoran : jelaKonobaDalmacija) {
                if (jeloRestoranRepository.findById(jeloRestoran.getJeloRestoranId()).isEmpty()) {
                    jeloRestoranRepository.save(jeloRestoran);
                    System.out.println("Added product: " + jeloRestoran.getNaziv());
                }else{
                    System.out.println("Jelo " + jeloRestoran.getNaziv() + " is already added.");
                }
            }

            List<JeloRestoran> jelaSweetTreats = List.of(
                    new JeloRestoran(
                            11L,
                            restorani.get(5),
                            "Chocolate Cake",
                            "Sočni čokoladni kolač s vrhnjem.",
                            "obicni",
                            "30 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cokoladna-torta.JPG?t=2025-01-15T05%3A06%3A05.840Z"
                    ),
                    new JeloRestoran(
                            12L,
                            restorani.get(5),
                            "Fruit Tart",
                            "Voćna torta s kremom od vanilije.",
                            "obicni",
                            "35 HRK",
                            "Gluten, Laktoza, Voće",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/fruit-tart.jpg?t=2025-01-15T05%3A12%3A35.792Z"
                    ),
                    new JeloRestoran(
                            13L,
                            restorani.get(5),
                            "Cinnamon Rolls",
                            "Cimet rolice s glazurom.",
                            "obicni",
                            "25 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cinnamon-rolls.jpg?t=2025-01-15T05%3A12%3A44.827Z"
                    ),
                    new JeloRestoran(
                            14L,
                            restorani.get(5),
                            "Apple Pie",
                            "Jabuka pita sa svježim jabukama i cimetom.",
                            "obicni",
                            "28 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/apple-pie.jpeg?t=2025-01-15T05%3A12%3A19.064Z"
                    )
            );

            for (JeloRestoran jeloRestoran : jelaSweetTreats) {
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
