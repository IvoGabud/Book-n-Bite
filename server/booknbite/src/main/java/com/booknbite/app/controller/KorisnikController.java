package com.booknbite.app.controller;

import com.booknbite.app.model.Korisnik;
import com.booknbite.app.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KorisnikController {

    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public ResponseEntity<String> token(@AuthenticationPrincipal Jwt jwt){
        return ResponseEntity.ok("korisnik id: " + jwt.getClaim("sub") +
                "\nemail:" + jwt.getClaim("email"));
    }

    @PostMapping("/login")
    public ResponseEntity<String> addKorisnik(@RequestBody Korisnik korisnik){
        return ResponseEntity.ok(korisnikService.addKorisnik(korisnik));
    }

}