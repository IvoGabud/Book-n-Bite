package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.request.RestoranShortDTO;

import java.util.List;

public interface AdministratorService {
    List<Ocjenjivac> listaOcjenjivaca();
    List<RestoranShortDTO> listaRestorana();
    List<Restoran> listaVerifikacija();
    String verificiraj(String id);
    String obrisiKorisnika(String id);
    Ocjenjivac prikaziOcjenjivaca(String id);
}
