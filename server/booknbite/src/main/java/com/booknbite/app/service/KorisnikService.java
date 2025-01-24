package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Korisnik;
import com.booknbite.app.model.request.CreateGrupaRequest;
import com.booknbite.app.model.request.CreateJoinRequest;
import com.booknbite.app.model.request.CreateKorisnikRequest;
import com.booknbite.app.model.request.KorisnikBool;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface KorisnikService {
    KorisnikBool retrieveOcjenjivac(OAuth2User token);
    Korisnik addKorisnik(OAuth2User token, CreateKorisnikRequest ocjenjivacRequest);
    Grupa createGrupa(CreateGrupaRequest grupaRequest, OAuth2User token);
    boolean grupaExists(CreateJoinRequest joinRequest, OAuth2User token);
}
