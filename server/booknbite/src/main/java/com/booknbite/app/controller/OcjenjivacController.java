package com.booknbite.app.controller;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.service.OcjenjivacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
public class OcjenjivacController {

    private final OcjenjivacService ocjenjivacService;

    @Autowired
    public OcjenjivacController(OcjenjivacService ocjenjivacService){
        this.ocjenjivacService = ocjenjivacService;
    }

    @GetMapping("/requ")
    public ResponseEntity<Void> login(@AuthenticationPrincipal OAuth2User token){
        ocjenjivacService.addOcjenjivac(token);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://localhost:8080"))
                .build();
    }

}