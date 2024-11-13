package com.booknbite.app.controller;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.request.CreateOcjenjivacRequest;
import com.booknbite.app.model.request.OcjenjivacBool;
import com.booknbite.app.service.OcjenjivacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OcjenjivacController {

    private final OcjenjivacService ocjenjivacService;

    @Autowired
    public OcjenjivacController(OcjenjivacService ocjenjivacService){
        this.ocjenjivacService = ocjenjivacService;
    }

    @GetMapping("/is-logged-in")
    public ResponseEntity<OcjenjivacBool> retrieveOcjenjivac(@AuthenticationPrincipal OAuth2User token){
        if(token == null)
            return ResponseEntity.badRequest().body(new OcjenjivacBool());
        System.out.println(token);
        return ResponseEntity.ok(ocjenjivacService.retrieveOcjenjivac(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Ocjenjivac> login(@AuthenticationPrincipal OAuth2User token,
                                                      @RequestBody CreateOcjenjivacRequest ocjenjivacRequest){
        return ResponseEntity.ok(ocjenjivacService.addOcjenjivac(token, ocjenjivacRequest));
    }

}