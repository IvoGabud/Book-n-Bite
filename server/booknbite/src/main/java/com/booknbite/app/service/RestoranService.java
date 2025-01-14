package com.booknbite.app.service;

import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.request.CreateJeloRestoranRequest;
import com.booknbite.app.model.request.CreateRestoranInfo;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface RestoranService {
    Boolean ispuniFormu(OAuth2User token, CreateRestoranInfo restoranInfo);
    Restoran dohvatiRestoran(OAuth2User token);
    String napraviJelo(CreateJeloRestoranRequest jeloRestoranRequest, OAuth2User token);
}
