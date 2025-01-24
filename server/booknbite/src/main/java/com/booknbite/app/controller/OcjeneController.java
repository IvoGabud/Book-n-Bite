package com.booknbite.app.controller;

import com.booknbite.app.model.request.JeloRestoranDTO;
import com.booknbite.app.model.request.RestoranShortDTO;
import com.booknbite.app.service.JeloRestoranService;
import com.booknbite.app.service.OcjenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

//kontroler za funkcije objasnjene u OcjenaServiceImpl
@Controller
public class OcjeneController {

    private final JeloRestoranService jeloRestoranService;
    private final OcjenaService ocjenaService;

    @Autowired
    public OcjeneController(JeloRestoranService jeloRestoranService, OcjenaService ocjenaService){
        this.jeloRestoranService = jeloRestoranService;
        this.ocjenaService = ocjenaService;
    }

    @GetMapping("/products/{groupCode}")
    public ResponseEntity<List<JeloRestoranDTO>> dohvatiJela(@PathVariable String groupCode){
        return ResponseEntity.ok(jeloRestoranService.getJeloRestoranList(groupCode));
    }

    @PostMapping("/rating/{groupCode}")
    public ResponseEntity<String> spremiOcjene(
            @PathVariable String groupCode,
            @AuthenticationPrincipal OAuth2User token,
            @RequestBody Map<String, Integer> map
            ){
        return ResponseEntity.ok(ocjenaService.spremiOcjene(groupCode, token, map));
    }

    @GetMapping("/waiting/{groupCode}")
    public ResponseEntity<Boolean> provjeriOcjene(@PathVariable String groupCode){
        if(ocjenaService.provjeriOcjene(groupCode))
            return ResponseEntity.ok(true);
        return ResponseEntity.badRequest().body(false);
    }

    @GetMapping("/get-recommended/{groupCode}")
    public ResponseEntity<List<RestoranShortDTO>> kalkulirajPreporuku(@PathVariable String groupCode){
        return ResponseEntity.ok(ocjenaService.kalkulirajPreporuku(groupCode));
    }
}
