package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface KorisnikService {
    Ocjenjivac addKorisnik(OAuth2User token);
}
