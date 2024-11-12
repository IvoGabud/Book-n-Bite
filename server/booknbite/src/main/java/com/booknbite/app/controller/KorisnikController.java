package com.booknbite.app.controller;

import com.booknbite.app.model.Korisnik;
import com.booknbite.app.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
public class KorisnikController {

    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/poz")
    public ResponseEntity<String> sayPoz(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> token(@AuthenticationPrincipal OAuth2User principal){
        return ResponseEntity.ok("name: " + principal.getAttribute("name") +
                "\nemail:" + principal.getAttribute("email"));
    }

    @PostMapping("/login")
    public ResponseEntity<String> addKorisnik(@RequestBody Korisnik korisnik){
        return ResponseEntity.ok(korisnikService.addKorisnik(korisnik));
    }

}