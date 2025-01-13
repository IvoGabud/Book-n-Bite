package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.Restoran;

import java.util.List;

public interface AdministratorService {
    List<Ocjenjivac> listaOcjenjivaca();
    List<Restoran> listaRestorana();
    List<Restoran> listaVerifikacija();
    String verificiraj(String id);
}
