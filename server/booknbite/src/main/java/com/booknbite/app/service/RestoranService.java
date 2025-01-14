package com.booknbite.app.service;

import com.booknbite.app.model.request.CreateJeloRestoranRequest;
import com.booknbite.app.model.request.CreateRestoranInfo;
import com.booknbite.app.model.request.JeloRestoranDTO;
import com.booknbite.app.model.request.RestoranDTO;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;

public interface RestoranService {
    Boolean ispuniFormu(OAuth2User token, CreateRestoranInfo restoranInfo);
    RestoranDTO dohvatiRestoran(OAuth2User token);
    String napraviJelo(CreateJeloRestoranRequest jeloRestoranRequest, OAuth2User token);
    Map<String, List<JeloRestoranDTO>> dohvatiJelaPoKategoriji(OAuth2User token);
}
