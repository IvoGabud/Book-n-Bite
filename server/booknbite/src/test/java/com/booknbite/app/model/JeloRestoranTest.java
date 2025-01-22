package com.booknbite.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JeloRestoranTest {
    @Test
    void testJeloProperties() {
        Restoran restoranExample = new Restoran();
        JeloRestoran jeloRestoran = new JeloRestoran(
                1L,
                restoranExample,
                "Pizza Example",
                "Opis pizze",
                "obicni",
                "10 Eur",
                "Gluten, Laktoza",
                "ExampleUrl"
        );

        assertEquals(Long.valueOf(1), jeloRestoran.getJeloRestoranId());
        assertEquals(restoranExample, jeloRestoran.getRestoran());
        assertEquals("Pizza Example", jeloRestoran.getNaziv());
        assertEquals("Opis pizze", jeloRestoran.getOpis());
        assertEquals("obicni", jeloRestoran.getKategorija());
        assertEquals("10 Eur", jeloRestoran.getCijena());
        assertEquals("Gluten, Laktoza", jeloRestoran.getAlergeni());
        assertEquals("ExampleUrl", jeloRestoran.getSlikaJelaUrl());


    }

}