package com.booknbite.app.controller;

import com.booknbite.app.model.Korisnik;
import com.booknbite.app.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KorisnikController {

    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> addKorisnik(@RequestBody Korisnik korisnik){
        if(korisnikService.addKorisnik(korisnik))
            return ResponseEntity.ok("Korisnik added.");
        return ResponseEntity.badRequest().body("entity is garbage");
    }

}
