package com.booknbite.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestoranTest {
    @Test
    void testRestoran() {
        Restoran restoran = new Restoran();
        restoran.setNazivRestoran("Test");
        restoran.setLatLok(45.00);
        restoran.setLngLok(16.00);
        restoran.setRadnoVrijemeOd("10:00");
        restoran.setRadnoVrijemeDo("00:00");
        restoran.setCjenovniRang(CjenovniRang.JEFTINO);
        restoran.setBrojTelefona("01 234 567");
        restoran.setPoveznicaSlike("example.jpg");
        restoran.setUsername("testRestoran");
        restoran.setFirstName("Test");
        restoran.setLastName("Restoran");
        restoran.setEmail("testRestoran@gmail.com");
        restoran.setIsVerified(false);
        restoran.setIsFilled(false);

        assertEquals("Test", restoran.getNazivRestoran());
        assertEquals(45.00, restoran.getLatLok());
        assertEquals(16.00, restoran.getLngLok());
        assertEquals("10:00", restoran.getRadnoVrijemeOd());
        assertEquals("00:00", restoran.getRadnoVrijemeDo());
        assertEquals(CjenovniRang.JEFTINO, restoran.getCjenovniRang());
        assertEquals("01 234 567", restoran.getBrojTelefona());
        assertEquals("example.jpg", restoran.getPoveznicaSlike());
        assertEquals(false, restoran.getIsVerified());
        assertEquals(false, restoran.getIsFilled());
        assertEquals("testRestoran", restoran.getUsername());
        assertEquals("Test", restoran.getFirstName());
        assertEquals("Restoran", restoran.getLastName());
        assertEquals("testRestoran@gmail.com", restoran.getEmail());
    }
}