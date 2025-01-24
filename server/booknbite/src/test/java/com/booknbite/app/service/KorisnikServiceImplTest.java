package com.booknbite.app.service;

import com.booknbite.app.model.*;

import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.KorisnikRepository;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.KorisnikBool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.oauth2.core.user.OAuth2User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;


class KorisnikServiceImplTest {
    @Mock
    private OcjenjivacRepository ocjenjivacRepository;
    @Mock
    private KorisnikRepository korisnikRepository;
    @InjectMocks
    private KorisnikServiceImpl korisnikService;

    @Mock
    private OAuth2User token;

    @BeforeEach
    public void KorisnikServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void retrieveOcjenjivacTest() {
        when(token.getAttribute("sub")).thenReturn("user123");
        when(token.getAttribute("name")).thenReturn("userExample");
        when(token.getAttribute("email")).thenReturn("user@example.com");

        Korisnik mockUser = new Ocjenjivac();
        when(korisnikRepository.findById("user123")).thenReturn(Optional.of(mockUser));
        when(ocjenjivacRepository.getReferenceById("user123")).thenReturn((Ocjenjivac) mockUser);

        KorisnikBool result = korisnikService.retrieveOcjenjivac(token);

        assertEquals("userExample", result.getOcjenjivacIme());
        assertEquals("user123", result.getOcjenjivacId());
        assertEquals("user@example.com", result.getEmail());
        assertEquals(UserType.OCJENJIVAC, result.getUserType());
    }
}