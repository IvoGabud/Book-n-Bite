package com.booknbite.app.controller;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OcjenjivacController {

    private final KorisnikService korisnikService;

    @Autowired
    public OcjenjivacController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @GetMapping("/request")
    public ResponseEntity<Ocjenjivac> login(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(korisnikService.addKorisnik(token));
    }

}