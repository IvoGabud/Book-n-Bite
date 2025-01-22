package com.booknbite.app.service;

import com.booknbite.app.model.Korisnik;
import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.repository.KorisnikRepository;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.RestoranShortDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdministratorServiceImplTest {
    @Mock
    private OcjenjivacRepository ocjenjivacRepository;

    @Mock
    private RestoranRepository restoranRepository;

    @InjectMocks
    private AdministratorServiceImpl administratorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVerificiraj() {
        Restoran restoran = new Restoran();
        restoran.setIsVerified(false);
        when(restoranRepository.findById("1")).thenReturn(Optional.of(restoran));
        String result = administratorService.verificiraj("1");
        assertEquals("Restoran je verificiran.", result);
        assertTrue(restoran.getIsVerified());
        verify(restoranRepository, times(1)).findById("1");
        verify(restoranRepository, times(1)).save(restoran);

    }

    @Test
    public void testListaOcjenjivaca() {
        List<Ocjenjivac> mockListaOcjenjivaca = new ArrayList<>();
        mockListaOcjenjivaca.add(new Ocjenjivac());
        mockListaOcjenjivaca.add(new Ocjenjivac());
        mockListaOcjenjivaca.add(new Ocjenjivac());

        when(ocjenjivacRepository.findAll()).thenReturn(mockListaOcjenjivaca);

        List<Ocjenjivac> rezultat = administratorService.listaOcjenjivaca();
        assertEquals(3, rezultat.size());
    }
}