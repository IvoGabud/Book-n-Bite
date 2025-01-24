package com.booknbite.app.controller;

import com.booknbite.app.model.request.CreateJeloRestoranRequest;
import com.booknbite.app.model.request.CreateRestoranInfo;
import com.booknbite.app.model.request.JeloRestoranDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//kontroler za funkcije objasnjene u RestoranServiceImpl
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

    @GetMapping("/restaurant-info")
    public ResponseEntity<RestoranDTO> dohvatiRestoran(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(restoranService.dohvatiRestoran(token));
    }

    @PostMapping("/restaurant-dish")
    public ResponseEntity<String> napraviJelo(@RequestParam("naziv") String naziv,
                                              @RequestParam("opis") String opis,
                                              @RequestParam("kategorija") String kategorija,
                                              @RequestParam("cijena") Long cijena,
                                              @RequestParam("alergeni") String alergeni,
                                              @RequestParam("imageSrc") MultipartFile imageSrc,
                                              @AuthenticationPrincipal OAuth2User token) throws IOException {
        CreateJeloRestoranRequest request = new CreateJeloRestoranRequest(naziv, opis, kategorija, cijena, alergeni, imageSrc);
        return ResponseEntity.ok(restoranService.napraviJelo(request, token));
    }

    @GetMapping("/dishes")
    public ResponseEntity<Map<String, List<JeloRestoranDTO>>> dohvatiJelaPoKategoriji(@AuthenticationPrincipal OAuth2User token){
        return ResponseEntity.ok(restoranService.dohvatiJelaPoKategoriji(token));
    }
}
