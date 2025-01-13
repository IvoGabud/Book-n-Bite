package com.booknbite.app.controller;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.request.UpdateOcjenjivacRequest;
import com.booknbite.app.service.OcjenjivacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OcjenjivacController {

    private final OcjenjivacService ocjenjivacService;

    @Autowired
    public OcjenjivacController(OcjenjivacService ocjenjivacService){
        this.ocjenjivacService = ocjenjivacService;
    }

    @GetMapping("/get-reviewer")
    public ResponseEntity<Ocjenjivac> ocjenjivacPodaci(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(ocjenjivacService.ocjenjivacPodaci(token));
    }

    @PutMapping("/update-reviewer")
    public ResponseEntity<String> urediPodatke(@AuthenticationPrincipal OAuth2User token, @RequestBody UpdateOcjenjivacRequest ocjenjivacRequest){
        return ResponseEntity.ok(ocjenjivacService.urediPodatke(token, ocjenjivacRequest));
    }
}
