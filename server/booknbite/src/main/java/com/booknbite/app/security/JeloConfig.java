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
                    ),
                    new Restoran(
                            "Tavern Istria",
                            44.866623, // latitude (Pula)
                            13.849579, // longitude (Pula)
                            "11:00",
                            "00:00",
                            CjenovniRang.SREDNJE,
                            "+385911112233",
                            "https://example.com/images/tavern-istria.jpg",
                            "istria_user",
                            "Bruno",
                            "Ilić",
                            true,
                            true,
                            "ID007",
                            "bruno.ilic@example.com",
                            "tavernIstria"
                    ),
                    new Restoran(
                            "Beachside BBQ",
                            43.296670, // latitude (Makarska)
                            17.017780, // longitude (Makarska)
                            "10:00",
                            "01:00",
                            CjenovniRang.SREDNJE,
                            "+385927723444",
                            "https://example.com/images/beachside-bbq.jpg",
                            "beach_user",
                            "Marija",
                            "Radić",
                            true,
                            true,
                            "ID008",
                            "marija.radic@example.com",
                            "beachsideBBQ"
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
                            "Pizza Štapići",
                            "Hrskavi pizza štapići punjeni sirom, uz umak od rajčice za brzi zalogaj.",
                            "brza-hrana",
                            "30 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/pizza-sticks.jpg"
                    ),
                    new JeloRestoran(
                            4L,
                            restorani.get(0),
                            "Hrskavi Krumpirići",
                            "Domaći krumpirići uz začine i umak po izboru.",
                            "brza-hrana",
                            "25 HRK",
                            "Može sadržavati tragove glutena",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/wedges.jpg"
                    ),
                    new JeloRestoran(
                            5L,
                            restorani.get(0),
                            "Čokoladni Lava Kolač",
                            "Topli čokoladni biskvit s tekućom sredinom, poslužen uz kuglicu sladoleda.",
                            "desert",
                            "35 HRK",
                            "Gluten, Laktoza, Jaja",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/lava-cake.jpg"
                    ),
                    new JeloRestoran(
                            6L,
                            restorani.get(0),
                            "Tiramisu",
                            "Klasični talijanski desert s kremom od mascarponea i espressom.",
                            "desert",
                            "40 HRK",
                            "Gluten, Laktoza, Jaja",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/tiramisu.jpg"
                    ),
                    new JeloRestoran(
                            7L,
                            restorani.get(0),
                            "Domaći Ledeni Čaj",
                            "Osvježavajući ledeni čaj s okusom limuna i mentom.",
                            "pica",
                            "15 HRK",
                            "Bez alergena",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/ice-tea.jpg"
                    ),
                    new JeloRestoran(
                            8L,
                            restorani.get(0),
                            "Coca cola",
                            "legendarna Coca cola.",
                            "pica",
                            "12 HRK",
                            "Može sadržavati tragove sulfita",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cola.jpg"
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
                            9L,
                            restorani.get(1),
                            "Pašticada",
                            "Tradicionalno dalmatinsko jelo s govedinom, povrćem i vinom.",
                            "obicni",
                            "80 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/pasticada.jpg?t=2025-01-15T05%3A08%3A37.712Z"
                    ),
                    new JeloRestoran(
                            10L,
                            restorani.get(1),
                            "Grilled Fish",
                            "Svježe pečena riba s limunom i maslinovim uljem.",
                            "obicni",
                            "90 HRK",
                            "Riba, Gluten",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/grilled-fish.jpg?t=2025-01-15T05%3A08%3A59.004Z"
                    ),
                    new JeloRestoran(
                            11L,
                            restorani.get(1),
                            "Ćevapi",
                            "Tradicionalni ćevapi s lukom i kajmakom.",
                            "brza-hrana",
                            "50 HRK",
                            "Gluten",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cevapi.jpg?t=2025-01-15T05%3A09%3A25.809Z"
                    ),
                    new JeloRestoran(
                            12L,
                            restorani.get(1),
                            "Soparnik",
                            "Dalmatinski soparnik s blitvom i maslinovim uljem.",
                            "brza-hrana",
                            "40 HRK",
                            "Gluten",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/soparnik.jpeg?t=2025-01-15T05%3A10%3A07.298Z"
                    ),
                    new JeloRestoran(
                            13L,
                            restorani.get(1),
                            "Rožata",
                            "Dalmatinski kremasti desert s karamel preljevom.",
                            "desert",
                            "35 HRK",
                            "Jaja, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/rozata.jpg"
                    ),
                    new JeloRestoran(
                            14L,
                            restorani.get(1),
                            "Fritule",
                            "Prženi dalmatinski uštipci posuti šećerom u prahu ili posluženi uz čokoladni preljev.",
                            "desert",
                            "30 HRK",
                            "Gluten, Laktoza, Jaja",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/fritule.jpg"
                    ),
                    new JeloRestoran(
                            15L,
                            restorani.get(1),
                            "Domaće Crno Vino",
                            "Lokalno crno vino iz dalmatinskih vinograda.",
                            "pica",
                            "60 HRK (butelja)",
                            "Sulfiti",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/crno-vino.jpg"
                    ),
                    new JeloRestoran(
                            16L,
                            restorani.get(1),
                            "Rakija Travarica",
                            "Tradicionalna domaća rakija s aromom dalmatinskog bilja.",
                            "pica",
                            "15 HRK (čašica)",
                            "Alkohol",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/travarica.jpg"
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
                            17L,
                            restorani.get(5), // Sweet Treats
                            "Donut Bites",
                            "Mini krafnice punjene čokoladom.",
                            "brza-hrana",
                            "20 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/donut-bites.jpg"
                    ),
                    new JeloRestoran(
                            18L,
                            restorani.get(5),
                            "Waffle on a Stick",
                            "Hrskav vafl na štapiću s preljevom po izboru.",
                            "brza-hrana",
                            "25 HRK",
                            "Gluten, Laktoza, Jaja",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/waffle-on-stick.jpg"
                    ),
                    new JeloRestoran(
                            19L,
                            restorani.get(5),
                            "Cinnamon Rolls",
                            "Cimet rolice s glazurom.",
                            "desert",
                            "25 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cinnamon-rolls.jpg?t=2025-01-15T05%3A12%3A44.827Z"
                    ),
                    new JeloRestoran(
                            20L,
                            restorani.get(5),
                            "Apple Pie",
                            "Jabuka pita sa svježim jabukama i cimetom.",
                            "desert",
                            "28 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/apple-pie.jpeg?t=2025-01-15T05%3A12%3A19.064Z"
                    ),
                    new JeloRestoran(
                            21L, // novi ID
                            restorani.get(5),
                            "Mixed Berry Granola",
                            "Hrskave zobene pahuljice s orašastim plodovima i mješavinom bobičastog voća.",
                            "obicni",
                            "22 HRK",
                            "Gluten, Mogući tragovi orašastih plodova",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/mixed-berry-granola.jpg"
                    ),
                    new JeloRestoran(
                            22L,
                            restorani.get(5),
                            "Tropical Smoothie",
                            "Osvježavajući voćni smoothie s kombinacijom manga, ananasa i banane.",
                            "obicni",
                            "22 HRK",
                            "Mogući tragovi orašastih plodova",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/tropical-smothie.jpg"
                    ),
                    new JeloRestoran(
                            23L,
                            restorani.get(5),
                            "Hot Chocolate",
                            "Topla čokolada poslužena s dodatkom šlaga.",
                            "pica",
                            "18 HRK",
                            "Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/hot-chocholate.jpg"
                    ),
                    new JeloRestoran(
                            24L,
                            restorani.get(5),
                            "Milkshake",
                            "Kremasti milkshake s okusom vanilije ili čokolade.",
                            "pica",
                            "22 HRK",
                            "Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/milkshake2.jpg"
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
            List<JeloRestoran> jelaTavernIstria = List.of(
                    new JeloRestoran(
                            25L,
                            restorani.get(6),
                            "Fritule na istarski",
                            "Tradicionalne istarske fritule poslužene uz šećer u prahu.",
                            "brza-hrana",
                            "25 HRK",
                            "Gluten, Laktoza, Jaja",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/fritule-na-istarski.jpg"
                    ),
                    new JeloRestoran(
                            26L,
                            restorani.get(6),
                            "Bruschetta Istriana",
                            "Tostirani kruh s rajčicom, maslinovim uljem i istarskim začinskim biljem.",
                            "brza-hrana",
                            "28 HRK",
                            "Gluten, Mogući tragovi orašastih plodova",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/bruschetta.jpg"
                    ),

                    // obicni (2)
                    new JeloRestoran(
                            27L,
                            restorani.get(6),
                            "Istarska Maneštra",
                            "Gusta juha s grahom, krumpirom, suhim mesom i povrćem.",
                            "obicni",
                            "40 HRK",
                            "Mogući tragovi glutena",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/istarska-manestra.jpg"
                    ),
                    new JeloRestoran(
                            28L,
                            restorani.get(6),
                            "Fuži s Tartufima",
                            "Domaća istarska tjestenina fuži u kremastom umaku od tartufa.",
                            "obicni",
                            "65 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/fuzi-s-tartufima.jpg"
                    ),

                    // desert (2)
                    new JeloRestoran(
                            29L,
                            restorani.get(6),
                            "Kroštule",
                            "Hrskavi istarski desert posut šećerom u prahu.",
                            "desert",
                            "22 HRK",
                            "Gluten, Jaja",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/krostule.jpg"
                    ),
                    new JeloRestoran(
                            30L,
                            restorani.get(6),
                            "Fritule s Jabukama",
                            "Fritule s komadićima jabuke, cimetom i šećerom.",
                            "desert",
                            "25 HRK",
                            "Gluten, Jaja, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/fritule-s-jabukom.jpg"
                    ),

                    // pića (2)
                    new JeloRestoran(
                            31L,
                            restorani.get(6),
                            "Domaće Bijelo Vino",
                            "Lagano vino iz istarske vinarije.",
                            "pica",
                            "60 HRK (butelja)",
                            "Sulfiti",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/bijelo-vino.jpg"
                    ),
                    new JeloRestoran(
                            32L,
                            restorani.get(6),
                            "Rakija Medica",
                            "Slatka rakija s dodatkom meda, tradicionalni istarski specijalitet.",
                            "pica",
                            "15 HRK (čašica)",
                            "Alkohol",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/medica.jpg"
                    )
            );
            for (JeloRestoran jeloRestoran : jelaTavernIstria) {
                if (jeloRestoranRepository.findById(jeloRestoran.getJeloRestoranId()).isEmpty()) {
                    jeloRestoranRepository.save(jeloRestoran);
                    System.out.println("Added product: " + jeloRestoran.getNaziv());
                }else{
                    System.out.println("Jelo " + jeloRestoran.getNaziv() + " is already added.");
                }
            }
            List<JeloRestoran> jelaBeachsideBBQ = List.of(
                    new JeloRestoran(
                            33L,
                            restorani.get(7),
                            "BBQ pileća krilca",
                            "Pikantna pileća krilca s roštilja i umakom od rajčice.",
                            "brza-hrana",
                            "35 HRK",
                            "Mogući tragovi glutena",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/bbq-krilca.jpg"
                    ),
                    new JeloRestoran(
                            34L,
                            restorani.get(7),
                            "Loaded Fries",
                            "Pomfrit s otopljenim sirom, slaninom i umakom od BBQ-a.",
                            "brza-hrana",
                            "30 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/loaded-fires.jpg"
                    ),

                    // obicni (2)
                    new JeloRestoran(
                            35L,
                            restorani.get(7),
                            "Classic Burger",
                            "Burger s goveđim mesom, sirom, salatom i BBQ umakom.",
                            "obicni",
                            "50 HRK",
                            "Gluten, Laktoza",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/classic-burger.jpg"
                    ),
                    new JeloRestoran(
                            36L,
                            restorani.get(7),
                            "Plata morski plodovi",
                            "Miješana riba i plodovi mora na žaru, posluženi s limunom i maslinovim uljem.",
                            "obicni",
                            "85 HRK",
                            "Riba, Školjke",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/plata-morski.jpg"
                    ),

                    // desert (2)
                    new JeloRestoran(
                            37L,
                            restorani.get(7),
                            "Cheesecake s Jagodama",
                            "Klasični cheesecake s preljevom od svježih jagoda.",
                            "desert",
                            "35 HRK",
                            "Gluten, Laktoza, Jaja",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/cheescake.jpg"
                    ),
                    new JeloRestoran(
                            38L,
                            restorani.get(7),
                            "Palačinke s Nutellom",
                            "Tople palačinke punjene Nutellom i posipane lješnjacima.",
                            "desert",
                            "30 HRK",
                            "Gluten, Laktoza, Orašasti plodovi",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/palacinke.jpg"
                    ),

                    // pića (2)
                    new JeloRestoran(
                            39L,
                            restorani.get(7),
                            "Craft Pivo",
                            "Lokalno craft pivo osvježavajućeg okusa.",
                            "pica",
                            "20 HRK",
                            "Gluten, Alkohol",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/craft-pivo.jpg"
                    ),
                    new JeloRestoran(
                            40L,
                            restorani.get(7),
                            "sok od ananasa i kokosa",
                            "Egzotični sok s kokosovim mlijekom i svježim ananasom.",
                            "pica",
                            "25 HRK",
                            "Mogući tragovi orašastih plodova",
                            "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/public/images/proizvodi/sok-ananas.jpg"
                    )
            );

            for (JeloRestoran jeloRestoran : jelaBeachsideBBQ) {
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
