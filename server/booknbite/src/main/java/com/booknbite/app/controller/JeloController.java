package com.booknbite.app.controller;

import com.booknbite.app.model.Jelo;
import com.booknbite.app.model.request.CreateRatingRequest;
import com.booknbite.app.service.JeloService;
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

@Controller
public class JeloController {

    private final JeloService jeloService;
    private final OcjenaService ocjenaService;

    @Autowired
    public JeloController(JeloService jeloService, OcjenaService ocjenaService){
        this.jeloService = jeloService;
        this.ocjenaService = ocjenaService;
    }

    @GetMapping("/products/{groupCode}")
    public ResponseEntity<List<Jelo>> dohvatiJela(@PathVariable String groupCode){
        return ResponseEntity.ok(jeloService.getJeloList(groupCode));
    }

    @PostMapping("/rating/{groupCode}")
    public ResponseEntity<String> spremiOcjene(
            @PathVariable String groupCode,
            @AuthenticationPrincipal OAuth2User token,
            @RequestBody List<CreateRatingRequest> ratingRequest
            ){
        System.out.println(ratingRequest);
        return ResponseEntity.ok(ocjenaService.spremiOcjene(groupCode, token, ratingRequest));
    }
}
