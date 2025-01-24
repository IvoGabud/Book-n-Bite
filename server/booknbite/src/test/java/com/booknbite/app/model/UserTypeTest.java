package com.booknbite.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTypeTest {
    @Test
    void testUserTypeToString() {
        assertEquals("OCJENJIVAC", UserType.OCJENJIVAC.toString());
        assertEquals("RESTORAN", UserType.RESTORAN.toString());
        assertEquals("ADMINISTRATOR", UserType.ADMINISTRATOR.toString());

    }
}