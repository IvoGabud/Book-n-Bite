package com.booknbite.app.controller;

import com.booknbite.app.model.request.CreateRestoranInfo;
import com.booknbite.app.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RestoranController {

    private final RestoranService restoranService;

    @Autowired
    public RestoranController(RestoranService restoranService){
        this.restoranService = restoranService;
    }

    @PostMapping("/restaurant-info")
    public ResponseEntity<Boolean> ispuniFormu(@AuthenticationPrincipal OAuth2User token, @RequestBody CreateRestoranInfo restoranInfo){
        return ResponseEntity.ok(restoranService.ispuniFormu(token, restoranInfo));
    }
}
