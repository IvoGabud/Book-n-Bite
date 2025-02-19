package com.booknbite.app.controller;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.request.RestoranShortDTO;
import com.booknbite.app.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//kontroler za funkcije objasnjene u AdminServiceImpl
@Controller
public class AdminController {

    private final AdministratorService administratorService;

    @Autowired
    public AdminController(AdministratorService administratorService){
        this.administratorService = administratorService;
    }

    @GetMapping("/get-reviewers")
    public ResponseEntity<List<Ocjenjivac>> listaOcjenjivaca(){
        return ResponseEntity.ok(administratorService.listaOcjenjivaca());
    }

    @GetMapping("/get-restaurants")
    public ResponseEntity<List<RestoranShortDTO>> listaRestorana(){
        return ResponseEntity.ok(administratorService.listaRestorana());
    }

    @GetMapping("/get-verifications")
    public ResponseEntity<List<Restoran>> listaVerifikacija(){
        return ResponseEntity.ok(administratorService.listaVerifikacija());
    }

    @PostMapping("/verify/{id}")
    public ResponseEntity<String> verificiraj(@PathVariable String id){
        return ResponseEntity.ok(administratorService.verificiraj(id));
    }

    @DeleteMapping("/delete-account/{id}")
    public ResponseEntity<String> obrisiKorisnika(@PathVariable String id){
        return ResponseEntity.ok(administratorService.obrisiKorisnika(id));
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<Ocjenjivac> prikaziOcjenjivaca(@PathVariable String id){
        return ResponseEntity.ok(administratorService.prikaziOcjenjivaca(id));
    }

    @PostMapping("/block/{id}")
    public ResponseEntity<String> blokirajRacun(@PathVariable String id){
        return ResponseEntity.ok(administratorService.blokirajRacun(id));
    }
}
