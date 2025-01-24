package com.booknbite.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupaTest {
    @Test
    void testGrupaPropertiesNull() {
        Grupa grupa = new Grupa();

        assertNull(grupa.getGrupaKod());
    }

    @Test
    void testGrupaProperties() {
        Grupa grupa = new Grupa();
        grupa.setGrupaKod("LD6658");
        grupa.setGrupaKategorija("Roštilj");
        assertEquals("LD6658", grupa.getGrupaKod());
        assertEquals("Roštilj", grupa.getGrupaKategorija());
    }
}