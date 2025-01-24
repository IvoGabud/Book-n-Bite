package com.booknbite.app.controller;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.request.JeloRestoranDTO;
import com.booknbite.app.model.request.RestoranDTO;
import com.booknbite.app.model.request.UpdateOcjenjivacRequest;
import com.booknbite.app.service.OcjenjivacService;
import com.booknbite.app.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class OcjenjivacController {

    private final OcjenjivacService ocjenjivacService;
    private final RestoranService restoranService;

    @Autowired
    public OcjenjivacController(OcjenjivacService ocjenjivacService, RestoranService restoranService){
        this.ocjenjivacService = ocjenjivacService;
        this.restoranService = restoranService;
    }

    @GetMapping("/get-reviewer")
    public ResponseEntity<Ocjenjivac> ocjenjivacPodaci(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(ocjenjivacService.ocjenjivacPodaci(token));
    }

    @PutMapping("/update-reviewer")
    public ResponseEntity<String> urediPodatke(@AuthenticationPrincipal OAuth2User token, @RequestBody UpdateOcjenjivacRequest ocjenjivacRequest){
        return ResponseEntity.ok(ocjenjivacService.urediPodatke(token, ocjenjivacRequest));
    }


    @GetMapping("/get-restaurant/{id}")
    public ResponseEntity<RestoranDTO> prikaziRestoran(@PathVariable String id){
        return ResponseEntity.ok(restoranService.prikaziRestoran(id));
    }


    @GetMapping("/dishes/{id}")
    public ResponseEntity<Map<String, List<JeloRestoranDTO>>> dohvatiJelaPoKategorijiOcj(@PathVariable String id){
        return ResponseEntity.ok(restoranService.dohvatiJelaPoKategorijiOcj(id));
    }

    @PostMapping("/leave")
    public ResponseEntity<String> izlazIzGrupe(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(ocjenjivacService.izadiIzGrupe(token));
    }
}
