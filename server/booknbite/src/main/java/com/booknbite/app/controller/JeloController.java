package com.booknbite.app.controller;

import com.booknbite.app.model.JeloRestoran;
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

@Controller
public class JeloController {

    private final JeloRestoranService jeloRestoranService;
    private final OcjenaService ocjenaService;

    @Autowired
    public JeloController(JeloRestoranService jeloRestoranService, OcjenaService ocjenaService){
        this.jeloRestoranService = jeloRestoranService;
        this.ocjenaService = ocjenaService;
    }

    @GetMapping("/products/{groupCode}")
    public ResponseEntity<List<JeloRestoran>> dohvatiJela(@PathVariable String groupCode){
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
}
