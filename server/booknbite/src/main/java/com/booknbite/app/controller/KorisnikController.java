package com.booknbite.app.controller;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Korisnik;
import com.booknbite.app.model.request.CreateGrupaRequest;
import com.booknbite.app.model.request.CreateJoinRequest;
import com.booknbite.app.model.request.CreateKorisnikRequest;
import com.booknbite.app.model.request.KorisnikBool;
import com.booknbite.app.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//kontroler za funkcije opisane u service.OcjenjivacServiceImpl
@Controller
public class KorisnikController {

    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @GetMapping("/is-logged-in")
    public ResponseEntity<KorisnikBool> retrieveOcjenjivac(@AuthenticationPrincipal OAuth2User token){
        if(token == null)
            return ResponseEntity.badRequest().body(new KorisnikBool());
        System.out.println(token);
        return ResponseEntity.ok(korisnikService.retrieveOcjenjivac(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Korisnik> register(@AuthenticationPrincipal OAuth2User token,
                                             @RequestBody CreateKorisnikRequest korisnikRequest){
        return ResponseEntity.ok(korisnikService.addKorisnik(token, korisnikRequest));
    }

    @PostMapping("/create-group")
    public ResponseEntity<Grupa> createGrupa(@AuthenticationPrincipal OAuth2User token, @RequestBody CreateGrupaRequest grupaRequest){
        return ResponseEntity.ok(korisnikService.createGrupa(grupaRequest, token));
    }

    @PostMapping("/join-group")
    public ResponseEntity<String> joinGrupa(@AuthenticationPrincipal OAuth2User token, @RequestBody CreateJoinRequest joinRequest){
        if(korisnikService.grupaExists(joinRequest, token))
            return ResponseEntity.ok("Uspjesan ulazak u grupu!");
        return ResponseEntity.badRequest().body("Invalid group code.");
    }

}