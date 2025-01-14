package com.booknbite.app.controller;

import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.CreateJeloRestoranRequest;
import com.booknbite.app.model.request.CreateRestoranInfo;
import com.booknbite.app.model.request.JeloRestoranDAO;
import com.booknbite.app.model.request.RestoranDTO;
import com.booknbite.app.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public class RestoranController {

    private final RestoranService restoranService;
    private final RestoranRepository restoranRepository;

    @Autowired
    public RestoranController(RestoranService restoranService, RestoranRepository restoranRepository){
        this.restoranService = restoranService;
        this.restoranRepository = restoranRepository;
    }

    @PostMapping("/restaurant-info")
    public ResponseEntity<Boolean> ispuniFormu(@AuthenticationPrincipal OAuth2User token, @RequestBody CreateRestoranInfo restoranInfo){
        return ResponseEntity.ok(restoranService.ispuniFormu(token, restoranInfo));
    }

    @GetMapping("/restaurant-info")
    public ResponseEntity<RestoranDTO> dohvatiRestoran(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(restoranService.dohvatiRestoran(token));
    }

    @PostMapping("/restaurant-dish")
    public ResponseEntity<String> napraviJelo(@RequestBody CreateJeloRestoranRequest jeloRestoranRequest,
                                              @AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(restoranService.napraviJelo(jeloRestoranRequest, token));
    }

    @GetMapping("/dishes")
    public ResponseEntity<Map<String, List<JeloRestoranDAO>>> dohvatiJelaPoKategoriji(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(restoranService.dohvatiJelaPoKategoriji(token));
    }
}
