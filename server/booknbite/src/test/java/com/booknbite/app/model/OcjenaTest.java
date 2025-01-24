package com.booknbite.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OcjenaTest {
    @Test
    void testOcjenaPropertiesNull() {
        Ocjena ocjena = new Ocjena();
        ocjena.setOcjena(3);
        assertNull(ocjena.getGrupaKod());
    }

    @Test
    void testOcjenaProperties() {
        Ocjena ocjena = new Ocjena();
        Grupa grupa = new Grupa();
        ocjena.setOcjena(3);
        ocjena.setIdJela(111L);
        ocjena.setIdOcjenjivac("001");
        ocjena.setGrupa(grupa);
        ocjena.setGrupaKod("LD6658");

        assertEquals(3, ocjena.getOcjena());
        assertEquals(111L, ocjena.getIdJela());
        assertEquals("001", ocjena.getIdOcjenjivac());
        assertEquals(grupa, ocjena.getGrupa());
        assertEquals("LD6658", ocjena.getGrupaKod());

    }
}