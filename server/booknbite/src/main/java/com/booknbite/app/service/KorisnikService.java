package com.booknbite.app.service;

import com.booknbite.app.model.Korisnik;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface KorisnikService {
    Korisnik addKorisnik(OAuth2User token);
}
